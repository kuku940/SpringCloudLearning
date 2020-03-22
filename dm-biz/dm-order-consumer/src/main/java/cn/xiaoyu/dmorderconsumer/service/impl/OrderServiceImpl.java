package cn.xiaoyu.dmorderconsumer.service.impl;

import cn.xiaoyu.common.client.client.*;
import cn.xiaoyu.common.common.Dto;
import cn.xiaoyu.common.common.DtoUtil;
import cn.xiaoyu.common.module.pojo.*;
import cn.xiaoyu.common.utils.BaseException;
import cn.xiaoyu.common.utils.Constants;
import cn.xiaoyu.common.utils.EmptyUtils;
import cn.xiaoyu.common.utils.IdWorker;
import cn.xiaoyu.common.vo.CreateOrderVo;
import cn.xiaoyu.dmorderconsumer.exception.OrderErrorCode;
import cn.xiaoyu.dmorderconsumer.service.OrderService;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private RestDmItemClient restDmItemClient;
    @Autowired
    private RestDmSchedulerSeatClient restDmSchedulerSeatClient;
    @Autowired
    private RestDmSchedulerSeatPriceClient restDmSchedulerSeatPriceClient;
    @Autowired
    private RestDmOrderClient restDmOrderClient;
    @Autowired
    private RestDmLinkUserClient restDmLinkUserClient;
    @Autowired
    private RestDmOrderLinkUserClient restDmOrderLinkUserClient;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Dto createOrder(CreateOrderVo orderVo) {
        //先查询对应的商品信息，如果没有，则直接返回错误信息
        DmItem dmItem = restDmItemClient.getDmItemById(orderVo.getItemId());
        if (EmptyUtils.isEmpty(dmItem)) {
            throw new BaseException(OrderErrorCode.ORDER_NO_DATA);
        }
        //生成订单唯一编号
        String orderNo = IdWorker.getId();
        //拆分座位集合信息
        String[] seatArray = orderVo.getSeatPositions().split(",");
        //总价格
        double totalAmount = 0;
        //座位价格集合
        Double[] doublePrices = new Double[seatArray.length];
        DmSchedulerSeat dmSchedulerSeat = null;
        for (int i = 0; i < seatArray.length; i++) {
            String[] seats = seatArray[i].split("_");
            //查询每个座位的信息
            dmSchedulerSeat = restDmSchedulerSeatClient.getDmSchedulerSeatByOrder(
                    orderVo.getSchedulerId(),
                    Integer.parseInt(seats[0]),
                    Integer.parseInt(seats[1]));
            //更新座位的状态为锁定状态
            dmSchedulerSeat.setStatus(Constants.SchedulerSeatStatus.SCHEDULER_SEAT_TOPAY);
            //更新下单用户
            dmSchedulerSeat.setUserId(orderVo.getUserId());
            dmSchedulerSeat.setUpdatedTime(new Date());
            //更新订单编号
            dmSchedulerSeat.setOrderNo(orderNo);
            //更新数据库
            restDmSchedulerSeatClient.qdtxModifyDmSchedulerSeat(dmSchedulerSeat);
            //计算总价格
            DmSchedulerSeatPrice dmSchedulerSeatPrice = restDmSchedulerSeatPriceClient.getDmSchedulerSeatPriceBySchedulerIdAndArea(
                    dmSchedulerSeat.getAreaLevel(),
                    dmSchedulerSeat.getScheduleId());
            totalAmount += dmSchedulerSeatPrice.getPrice();
            //保存座位价格信息
            doublePrices[i] = dmSchedulerSeatPrice.getPrice();
        }
        //生成订单信息
        DmOrder dmOrder = new DmOrder();
        dmOrder.setOrderNo(orderNo);
        BeanUtils.copyProperties(orderVo, dmOrder);
        dmOrder.setItemName(dmItem.getItemName());
        dmOrder.setOrderType(Constants.SchedulerSeatStatus.SCHEDULER_SEAT_TOPAY);
        dmOrder.setTotalCount(seatArray.length);
        //如果勾选了保险，则增加到总金额里
        if (orderVo.getIsNeedInsurance().equals(Constants.OrderStatus.ISNEEDINSURANCE_YES)) {
            totalAmount += Constants.OrderStatus.NEEDINSURANCE_MONEY;
        }
        dmOrder.setInsuranceAmount(Constants.OrderStatus.NEEDINSURANCE_MONEY);
        dmOrder.setCreatedTime(new Date());
        dmOrder.setTotalAmount(totalAmount);
        //更新插入订单数据,并且放回当前订单数据的主键ID
        Long orderID = 0L;
        try {
            orderID = restDmOrderClient.qdtxAddDmOrder(dmOrder);
            Assert.notNull(orderID, "OrderId is Null!");
        } catch (Exception e) {
            logger.error("add Order Id Error", e);
            //创建订单失败，重置之前的订单座位信息
            sendResetSeatMsg(dmSchedulerSeat.getScheduleId(), seatArray);
            throw new BaseException(OrderErrorCode.ORDER_NO_DATA);
        }

        //更新相关关联用户
        String[] linkIds = orderVo.getLinkIds().split(",");
        for (int i = 0; i < linkIds.length; i++) {
            //查询关联用户信息
            DmLinkUser dmLinkUser = restDmLinkUserClient.getDmLinkUserById(Long.parseLong(linkIds[i]));
            if (EmptyUtils.isEmpty(dmLinkUser)) {
                //创建订单失败，重置之前的订单座位信息
                sendResetSeatMsg(dmSchedulerSeat.getScheduleId(), seatArray);
                //无法添加联系人，需要删除之前创建的订单
                sendDelOrderMsg(orderID);
                //重置订单明细关联人信息
                sendResetLinkUser(orderID);
                throw new BaseException(OrderErrorCode.ORDER_NO_DATA);
            }
            DmOrderLinkUser dmOrderLinkUser = new DmOrderLinkUser();
            dmOrderLinkUser.setOrderId(orderID);
            dmOrderLinkUser.setLinkUserId(dmLinkUser.getId());
            dmOrderLinkUser.setLinkUserName(dmLinkUser.getName());
            dmOrderLinkUser.setX(Integer.parseInt(seatArray[i].split("_")[0]));
            dmOrderLinkUser.setY(Integer.parseInt(seatArray[i].split("_")[1]));
            dmOrderLinkUser.setPrice(doublePrices[i]);
            dmOrderLinkUser.setCreatedTime(new Date());
            try {
                restDmOrderLinkUserClient.qdtxAddDmOrderLinkUser(dmOrderLinkUser);
            } catch (Exception e) {
                logger.error("add Order Link User Error", e);
                //创建订单失败，重置之前的订单座位信息
                sendResetSeatMsg(dmSchedulerSeat.getScheduleId(), seatArray);
                //无法添加联系人，需要删除之前创建的订单
                sendDelOrderMsg(orderID);
                //重置订单明细关联人信息
                sendResetLinkUser(orderID);
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderNo", orderNo);
        return DtoUtil.returnDataSuccess(jsonObject);
    }

    /**
     * 发送需要重置联系人的消息
     */
    private void sendResetLinkUser(Long orderID) {
        rabbitTemplate.convertAndSend(Constants.RabbitQueueName.TOPIC_EXCHANGE,
                Constants.RabbitQueueName.TO_RESET_LINKUSER_QUQUE,
                orderID,
                message -> {
                    //消息持久化，避免消息服务宕机后消息丢失
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    return message;
                });
    }

    /**
     * 发送需要删除订单的消息
     */
    private void sendDelOrderMsg(Long orderID) {
        rabbitTemplate.convertAndSend(Constants.RabbitQueueName.TOPIC_EXCHANGE,
                Constants.RabbitQueueName.TO_DEL_ORDER_QUQUE,
                orderID,
                message -> {
                    //消息持久化，避免消息服务宕机后消息丢失
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    return message;
                });
    }

    /**
     * 发送需要重置座位的消息
     */
    private void sendResetSeatMsg(Long scheduleId, String[] seatArray) {
        Map<String, Object> resetSeatMap = new HashMap<>();
        resetSeatMap.put("scheduleId", scheduleId);
        resetSeatMap.put("seats", seatArray);
        rabbitTemplate.convertAndSend(Constants.RabbitQueueName.TOPIC_EXCHANGE,
                Constants.RabbitQueueName.TO_RESET_SEAT_QUQUE,
                resetSeatMap,
                message -> {
                    //消息持久化，避免消息服务宕机后消息丢失
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    return message;
                });
    }

    /**
     * 重置座位状态信息
     */
    @RabbitListener(queues = Constants.RabbitQueueName.TO_RESET_SEAT_QUQUE)
    public void resetSeatMsg(Map<String, Object> resetSeatMap, Message message, Channel channel) {
        Long scheduleId = (Long) resetSeatMap.get("scheduleId");
        String[] seatArray = (String[]) resetSeatMap.get("seats");
        try {
            for (String seatStr : seatArray) {
                //更新每个座位信息
                String[] seats = seatStr.split("_");
                DmSchedulerSeat dmSchedulerSeat = restDmSchedulerSeatClient.getDmSchedulerSeatByOrder(
                        scheduleId,
                        Integer.parseInt(seats[0]),
                        Integer.parseInt(seats[1]));
                dmSchedulerSeat.setStatus(1);
                dmSchedulerSeat.setUserId(null);
                dmSchedulerSeat.setOrderNo(null);
                restDmSchedulerSeatClient.qdtxModifyDmSchedulerSeat(dmSchedulerSeat);
            }
        } catch (Exception e) {
            logger.error("Modify Scheduler Seat Error", e);
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            } catch (IOException e1) {
                logger.error("Basic Nack Error", e1);
            }
        }
    }

    /**
     * 删除订单
     */
    @RabbitListener(queues = Constants.RabbitQueueName.TO_DEL_ORDER_QUQUE)
    public void delOrderMsg(Long orderId, Message message, Channel channel) {
        try {
            restDmOrderClient.deleteDmOrderById(orderId);
        } catch (Exception e) {
            logger.error("delete Order Error", e);
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            } catch (IOException e1) {
                logger.error("Basic Nack Error", e1);
            }
        }
    }

    /**
     * 重置订单明细表关联人信息
     */
    @RabbitListener(queues = Constants.RabbitQueueName.TO_RESET_LINKUSER_QUQUE)
    public void delOrderlLinkUserMsg(Long orderId, Message message, Channel channel) {
        try {
            restDmOrderLinkUserClient.deleteDmOrderLinkUserByOrderId(orderId);
        } catch (Exception e) {
            logger.error("delete Order Link User Error", e);
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            } catch (IOException e1) {
                logger.error("Basic Nack Error", e1);
            }
        }
    }
}
