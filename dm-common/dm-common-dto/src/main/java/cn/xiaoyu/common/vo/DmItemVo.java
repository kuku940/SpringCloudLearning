package cn.xiaoyu.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 *   节目Vo
 */
@Data
public class DmItemVo implements Serializable {
    //
    private Long id;
    //节目名称
    private String itemName;
    //区域id
    private Long areaId;
    //区域名称
    private String areaName;
    //剧场地址
    private String address;
    //开售日期
    private String startDate;
    //结束日期
    private String endDate;
    //图片地址
    private String imgUrl;
    //最低价
    private Double minPrice;
}
