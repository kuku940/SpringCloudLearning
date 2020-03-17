package cn.xiaoyu.common.vo;

import lombok.Data;

/**
 * 亲子页猜你喜欢
 */
@Data
public class ParentAndChildVo {
    //商品主键
    private Long id;
    //节目名称
    private String itemName;
    //城市
    private Long areaId;
    //城市名称
    private String areaName;
    //节目所在地址
    private String address;
    //节目开始日期
    private String startDate;
    //节目结束日期
    private String endDate;
    //节目宣传图片
    private String imgUrl;
    //最低价格
    private Double minPrice;
}
