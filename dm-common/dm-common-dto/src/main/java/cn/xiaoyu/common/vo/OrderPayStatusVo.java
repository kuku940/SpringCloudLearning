package cn.xiaoyu.common.vo;

import lombok.Data;


@Data
public class OrderPayStatusVo {
    //订单编号
    private String orderNo;
    //订单的支付状态
    private Integer orderType;
}
