package cn.xiaoyu.common.vo;

import lombok.Data;

/**
 * 查询订单传输VO
 */
@Data
public class QueryOrderVo {
    //订单号
    private String orderNo;
    //商品名称
    private String itemName;
    //座位信息，逗号相隔
    private String seatName;
    //座位数量
    private Integer seatCount;
    //订单金额
    private Double totalAmount;
}
