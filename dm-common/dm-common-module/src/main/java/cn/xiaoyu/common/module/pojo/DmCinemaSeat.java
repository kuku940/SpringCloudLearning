package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *   剧场座位表
 */
@Data
public class DmCinemaSeat implements Serializable {
    //
    private Long id;
    //x坐标
    private Integer x;
    //y坐标
    private Integer y;
    //区域级别(1:A;2:B;3:C)
    private Integer areaLevel;
    //排期Id
    private Long cinemaId;
    //排序
    private Integer sort;
    //座位状态(1:有座位 0:没座位)
    private Integer status;
    //创建时间
    private Date createdTime;
    //更新时间
    private Date updatedTime;
}
