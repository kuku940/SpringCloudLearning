package cn.xiaoyu.common.vo;

import lombok.Data;

/**
 * 商品排期传输VO
 */
@Data
public class ItemSchedulerVo {
    //排期Id
    private Long id;
    //排期名称
    private String title;
    //商品Id
    private Long itemId;
    //开始日期
    private String startTime;
    //结束日期
    private String endTime;
    //剧场ID
    private Long cinemaId;
}
