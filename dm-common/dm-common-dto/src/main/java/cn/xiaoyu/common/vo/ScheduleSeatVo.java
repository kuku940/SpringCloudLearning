package cn.xiaoyu.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/***
 * 排期座位VO
 */
@Data
public class ScheduleSeatVo implements Serializable {
    private Long scheduleId;
    private Long cinemaId;
    private List<SeatPriceVo> seatPriceList;
    private List<SeatInfoVo> seatInfoList;
}
