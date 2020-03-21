package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *   节目排期座位价格表
 */
@Data
public class DmSchedulerSeatPrice implements Serializable {
    //主键
    private Long id;
    //价格
    private Double price;
    //区域级别(1:A;2:B;3:C)
    private Integer areaLevel;
    //排期Id
    private Long scheduleId;
    //座位存量
    private Integer seatNum;
    //
    private Date createdTime;
    //
    private Date updatedTime;
}
