package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/***
 *   剧场表
 */
@Data
public class DmCinema implements Serializable {
    //
    private Long id;
    //剧场名称
    private String name;
    //剧场地址
    private String address;
    //区域ID
    private Long areaId;
    //区域名称
    private String areaName;
    //X轴座位长度
    private Integer xLength;
    //Y轴座位长度
    private Integer yLength;
    //纬度
    private String latitude;
    //经度
    private String longitude;
    //创建时间
    private Date createdTime;
    //更新时间
    private Date updatedTime;
}
