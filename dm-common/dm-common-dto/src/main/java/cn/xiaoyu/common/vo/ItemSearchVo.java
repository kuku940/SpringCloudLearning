package cn.xiaoyu.common.vo;

import lombok.Data;

import java.io.Serializable;

/***
 * 商品查询返回的VO
 */
@Data
public class ItemSearchVo implements Serializable {
    private Long id;
    private String imgUrl;
    private String areaName;
    private String itemName;
    private String abstractMessage;
    private String startTime;
    private String endTime;
    private Double minPrice;
    private Double maxPrice;
    private String address;
    private String latitude;
    private String longitude;
    private Long itemTypeId1;
    private Long itemTypeId2;
    private Long areaId;
}
