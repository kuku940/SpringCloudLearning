package cn.xiaoyu.common.vo;

import lombok.Data;

/**
 * 商品排期对应价格传输VO
 */
@Data
public class ItemPriceVo {
    //商品价格Id
    private Long id;
    //排期Id
    private Long scheduleId;
    //价格
    private Double price;
    //座位状态(0:没座位 1:有座位)
    private Integer isHaveSeat;
}
