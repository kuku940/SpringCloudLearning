package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/***
 *   排期座位表
 */
@Data
public class DmSchedulerSeat implements Serializable {
    //
    private Long id;
    //x坐标
    private Integer x;
    //y坐标
    private Integer y;
    //区域级别(1:A;2:B;3:C)
    private Integer areaLevel;
    //排期Id
    private Long scheduleId;
    //订单编号
    private String orderNo;
    //如果已经售出记录购买用户id
    private Long userId;
    //座位状态(0:没座位 1:有座位 2:锁定待付款 3:已售出 )
    private Integer status;
    //排序
    private Integer sort;
    //创建时间
    private Date createdTime;
    //更新时间
    private Date updatedTime;
}
