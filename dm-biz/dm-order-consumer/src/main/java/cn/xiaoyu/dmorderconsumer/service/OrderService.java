package cn.xiaoyu.dmorderconsumer.service;

import cn.xiaoyu.common.common.Dto;
import cn.xiaoyu.common.vo.CreateOrderVo;

public interface OrderService {
    /**
     * 下单接口
     */
    Dto createOrder(CreateOrderVo orderVo);
}
