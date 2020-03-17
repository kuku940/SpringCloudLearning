package cn.xiaoyu.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SeatInfoVo implements Serializable {
    private Long id;
    private Integer x;
    private Integer y;
    private Integer areaLevel;
    private Long cinemaId;
    private Integer sort;
    private Integer status;
}
