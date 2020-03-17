package cn.xiaoyu.common.vo;

import lombok.Data;

/**
 * 订单管理传输VO
 */
@Data
public class ManagementOrderVo {
    //订单ID
    private Long id;
    //订单号
    private String orderNo;
    //商品名称
    private String itemName;
    //总价
    private Double totalAmount;
    //订单类型(0:未支付 -1:支付超时/支付取消 2:已支付)
    private Integer orderType;
    //购买数目
    private Integer num;
    //商品单价(x1_y1_price,x2_y2_price)
    private String unitPrice;
    //购买时间
    private String sellTime;
}
