package cn.xiaoyu.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 抢购商品消息
 */
@Data
public class DmItemMessageVo implements Serializable {
    //商品id
    private String itemId;
    //用户编号
    private String userId;
    //抢购状态
    private String status;
    //金额
    private double amount;
    //交易号
    private String tradeNo;
    //订单号
    private String orderNo;
    //支付方式（1：微信，2：支付宝）
    private Integer payMethod;
}
