package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *   订单表
 */
@Data
public class DmOrder implements Serializable {
    //主键
    private Long id;
    //订单编号
    private String orderNo;
    //下单用户Id
    private Long userId;
    //排期ID
    private Long schedulerId;
    //剧集Id(冗余)
    private Long itemId;
    //剧集名称（冗余）
    private String itemName;
    //微信交易号
    private String wxTradeNo;
    //支付宝交易号
    private String aliTradeNo;
    //订单类型(0:未支付 -1:支付超时/支付取消 2:已支付)
    private Integer orderType;
    //支付类型(1:微信支付 2：支付宝支付)
    private String payType;
    //购买数目
    private Integer totalCount;
    //
    private Long area;
    //0:WEB端 1:手机端 2:其他客户端
    private Integer sourceType;
    //是否需要发票（0：不需要 1：需要）
    private Integer isNeedInvoice;
    //发票类型（0：个人 1：公司）
    private Integer invoiceType;
    //发票抬头
    private String invoiceHead;
    //发票号
    private String invoiceNo;
    //是否需要保险(0：不需要 1:需要)
    private Integer isNeedInsurance;
    //总价
    private Double totalAmount;
    //保险金额
    private Double insuranceAmount;
    //创建时间
    private Date createdTime;
    //更新时间
    private Date updatedTime;
}
