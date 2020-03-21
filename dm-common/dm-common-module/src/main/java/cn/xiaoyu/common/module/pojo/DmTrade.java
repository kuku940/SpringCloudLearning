package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/***
 *
 */
@Data
public class DmTrade implements Serializable {
    //
    private String id;
    //业务订单号
    private String orderNo;
    //交易订单号
    private String tradeNo;
    //(1:支付宝 2:微信)
    private Integer payMethod;
    //交易金额
    private Double amount;
    //
    private Date createdTime;
    //
    private Date updatedTime;
}
