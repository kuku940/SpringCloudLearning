package cn.xiaoyu.common.vo;

import lombok.Data;

/**
 * 商品详情数据传递VO
 */
@Data
public class ItemDetailVo {
    //商品主键
    private Long id;
    //商品简介
    private String abstractMessage;
    //节目名称
    private String itemName;
    //一级分类ID
    private Long itemType1Id;
    //一级分类名称
    private String itemType1Name;
    //二级分类ID
    private Long itemType2Id;
    //二级分类名称
    private String itemType2Name;
    //区域id
    private Long areaId;
    //区域名称
    private String areaName;
    //演出开始时间
    private String startTime;
    //演出结束时间
    private String endTime;
    //状态(1:项目待定2:预售/预订3:开始售票4:演出开始)
    private String state;
    //基础描述
    private String basicDescription;
    //项目描述
    private String projectDescription;
    //温馨提示
    private String reminderDescription;
    //图片地址
    private String imgUrl;
    //剧场Id
    private Long cinemaId;
    //剧场地址
    private String address;
    //剧场经度
    private String latitude;
    //剧场纬度
    private String longitude;
    //平均评分
    private Double avgScore;
    //评论数目
    private Integer commentCount;
}
