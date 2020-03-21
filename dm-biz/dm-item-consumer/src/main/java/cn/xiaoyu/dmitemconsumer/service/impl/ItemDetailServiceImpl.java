package cn.xiaoyu.dmitemconsumer.service.impl;

import cn.xiaoyu.common.client.client.*;
import cn.xiaoyu.common.common.Dto;
import cn.xiaoyu.common.common.DtoUtil;
import cn.xiaoyu.common.module.pojo.*;
import cn.xiaoyu.common.utils.*;
import cn.xiaoyu.common.vo.ItemCommentVo;
import cn.xiaoyu.common.vo.ItemDetailVo;
import cn.xiaoyu.common.vo.ItemPriceVo;
import cn.xiaoyu.common.vo.ItemSchedulerVo;
import cn.xiaoyu.dmitemconsumer.exception.ItemErrorCode;
import cn.xiaoyu.dmitemconsumer.service.ItemDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ItemDetailServiceImpl implements ItemDetailService {
    private static final Logger logger = LoggerFactory.getLogger(ItemDetailServiceImpl.class);

    @Autowired
    private RestDmItemClient restDmItemClient;
    @Autowired
    private RestDmImageClient restDmImageClient;
    @Autowired
    private RestDmCinemaClient restDmCinemaClient;
    @Autowired
    private RestDmSchedulerClient restDmSchedulerClient;
    @Autowired
    private RestDmSchedulerSeatPriceClient restDmSchedulerSeatPriceClient;
    @Autowired
    private RestDmItemCommentClient restDmItemCommentClient;
    @Autowired
    private RestDmUserClient dmUserClient;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Dto<ItemDetailVo> queryItemDetail(Long id) {
        logger.info("[queryItemDetail]开始查询id为{}的商品详细信息", id);
        //查询对应ID的商品
        DmItem dmItem = restDmItemClient.getDmItemById(id);
        if (EmptyUtils.isEmpty(dmItem)) {
            return null;
        }
        //查询图片信息
        String imgUrl = getImageUrl(restDmImageClient, dmItem.getId(), Constants.Image.ImageType.NORMAL, Constants.Image.ImageCategory.ITEM);
        //获取剧场信息
        DmCinema dmCinema = restDmCinemaClient.getDmCinemaById(dmItem.getCinemaId());
        //组装返回数据
        ItemDetailVo itemDetailVo = copyData(dmItem, dmCinema, imgUrl);
        return DtoUtil.returnDataSuccess(itemDetailVo);
    }

    @Override
    public Dto<List<ItemSchedulerVo>> queryItemScheduler(Long id) {
        logger.info("[queryItemScheduler]开始查询id为{}的商品排期", id);
        List<ItemSchedulerVo> resultList = new ArrayList<>();
        //查询对应ID的商品
        DmItem dmItem = restDmItemClient.getDmItemById(id);
        if (EmptyUtils.isEmpty(dmItem)) {
            return null;
        }
        //查询对应的排期列表
        Map<String, Object> param = new HashMap<>();
        param.put("itemId", dmItem.getId());
        List<DmScheduler> dmSchedulerList = restDmSchedulerClient.getDmSchedulerListByMap(param);
        if (EmptyUtils.isEmpty(dmSchedulerList)) {
            throw new BaseException(ItemErrorCode.ITEM_NO_DATA);
        }
        //组装返回数据
        for (DmScheduler dmScheduler : dmSchedulerList) {
            ItemSchedulerVo itemSchedulerVo = new ItemSchedulerVo();
            BeanUtils.copyProperties(dmItem, itemSchedulerVo);
            BeanUtils.copyProperties(dmScheduler, itemSchedulerVo);
            itemSchedulerVo.setStartTime(DateUtil.format(dmScheduler.getStartTime()));
            itemSchedulerVo.setEndTime(DateUtil.format(dmScheduler.getEndTime()));
            resultList.add(itemSchedulerVo);
        }
        return DtoUtil.returnDataSuccess(resultList);
    }

    @Override
    public Dto<List<ItemPriceVo>> queryItemPrice(Long scheduleId) {
        logger.info("[queryItemPrice]开始查询id为{}的排期价格", scheduleId);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("scheduleId", scheduleId);
        //根据排期ID获取排期价格信息
        List<DmSchedulerSeatPrice> dmSchedulerSeatPrices = restDmSchedulerSeatPriceClient.getDmSchedulerSeatPriceListByMap(paramMap);
        List<ItemPriceVo> itemPriceVoList = new ArrayList<>();
        if (EmptyUtils.isEmpty(dmSchedulerSeatPrices)) {
            return null;
        }
        for (DmSchedulerSeatPrice seatPrice : dmSchedulerSeatPrices) {
            ItemPriceVo itemPriceVo = new ItemPriceVo();
            BeanUtils.copyProperties(seatPrice, itemPriceVo);
            //先查询出所有是有效座位且没有被锁定的座位数量
            Map<String, Object> lockMap = new HashMap<>();
            lockMap.put("status", 1);
            int lockNum = restDmSchedulerClient.getDmSchedulerCountByMap(lockMap);
            //对应的区域如果预定状态的座位数量少于总数代表还有座位
            int isHaveSeat = lockNum > 0 ? 1 : 0;
            itemPriceVo.setIsHaveSeat(isHaveSeat);
            itemPriceVoList.add(itemPriceVo);
        }
        return DtoUtil.returnDataSuccess(itemPriceVoList);
    }

    @Override
    public Dto<List<ItemCommentVo>> queryItemComment(Long itemId) {
        logger.info("[queryItemComment]开始查询id为{}的商品评论", itemId);
        //根据商品ID获取所有的剧评
        Map<String, Object> paramMapComment = new HashMap<>();
        paramMapComment.put("itemId", itemId);
        List<ItemCommentVo> itemCommentVoList = new ArrayList<>();
        List<DmItemComment> dmCommentList = restDmItemCommentClient.getDmItemCommentListByMap(paramMapComment);
        if (EmptyUtils.isEmpty(dmCommentList)) {
            return DtoUtil.returnDataSuccess(itemCommentVoList);
        }
        //根据剧评中的用户ID获取用户头像并封装返回数据
        for (DmItemComment dmItemComment : dmCommentList) {
            ItemCommentVo itemCommentVo = new ItemCommentVo();
            BeanUtils.copyProperties(dmItemComment, itemCommentVo);
            //查询用户信息
            DmUser dmUser = dmUserClient.getDmUserById(dmItemComment.getUserId());
            if (EmptyUtils.isNotEmpty(dmUser)) {
                itemCommentVo.setUserName(dmUser.getNickName());
            }
            //获取用户头像
            String imgUrl = getImageUrl(restDmImageClient, dmItemComment.getUserId(), Constants.Image.ImageType.NORMAL, Constants.Image.ImageCategory.USER);
            itemCommentVo.setImgUrl(imgUrl);
            itemCommentVo.setCreatedTime(DateUtil.format(dmItemComment.getCreatedTime()));
            itemCommentVoList.add(itemCommentVo);
        }
        return DtoUtil.returnDataSuccess(itemCommentVoList);
    }

    @Override
    public Dto commitItemComment(Long itemId, Long userId, Integer score, String comment) {
        //封装评论对象
        DmItemComment dmItemComment = new DmItemComment();
        dmItemComment.setItemId(itemId);
        dmItemComment.setUserId(userId);
        dmItemComment.setScore(score);
        dmItemComment.setContent(comment);
        dmItemComment.setCreatedTime(new Date());
        //添加剧评
        restDmItemCommentClient.qdtxAddDmItemComment(dmItemComment);
        return DtoUtil.returnDataSuccess(null);
    }

    /**
     * 获取图片信息
     *
     * @param targetId     图片id
     * @param type         图片类型
     * @param category     0:用户头像 1:商品图片
     * @param checkUserImg 是否是查询用户头像
     */
    public List<DmImage> getImageList(Long targetId, Integer type, Integer category, boolean checkUserImg) {
        Map<String, Object> paramMapImage = new HashMap<>();
        paramMapImage.put("targetId", targetId);
        if (!checkUserImg) {
            paramMapImage.put("type", type);
        }
        //图片类型为1，代表查询商品图片
        paramMapImage.put("category", category);
        return restDmImageClient.queryDmImageList(targetId, type, category);
    }


    /**
     * 统一封装VO格式返回数据
     */
    public ItemDetailVo copyData(DmItem dmItem, DmCinema dmCinema, String imgUrl) {
        ItemDetailVo itemDetailVo = new ItemDetailVo();
        BeanUtils.copyProperties(dmItem, itemDetailVo);
        itemDetailVo.setStartTime(DateUtil.format(dmItem.getStartTime()));
        itemDetailVo.setEndTime(DateUtil.format(dmItem.getEndTime()));
        itemDetailVo.setState(dmItem.getState() + "");
        itemDetailVo.setImgUrl(imgUrl);
        if (EmptyUtils.isNotEmpty(dmCinema)) {
            BeanUtils.copyProperties(dmCinema, itemDetailVo);
        }
        itemDetailVo.setId(dmItem.getId());
        itemDetailVo.setCommentCount(dmItem.getCommentCount());
        return itemDetailVo;
    }

    /**
     * 查询图片信息
     */
    public String getImageUrl(RestDmImageClient restDmImageClient, Long id, Integer type, Integer category) {
        //查询图片信息
        List<DmImage> dmImageList = null;
        //从reidis中获取图片信息
        String key = Constants.IMAGE_TOKEN_PREFIX + id + "_" + type + "_" + category;
        String imgUrl = (String) redisUtils.get(key);
        //如果redis中没有,则到数据库中获取
        if (EmptyUtils.isEmpty(imgUrl)) {
            dmImageList = restDmImageClient.queryDmImageList(id, type, category);
            imgUrl = dmImageList.get(0).getImgUrl();
            //同步图片到redis
            redisUtils.set(key, imgUrl);
        }
        return imgUrl;
    }
}
