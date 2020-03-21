package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmSchedulerSeatPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmSchedulerSeatPriceMapper {
    DmSchedulerSeatPrice getDmSchedulerSeatPriceById(@Param(value = "id") Long id);

    List<DmSchedulerSeatPrice> getDmSchedulerSeatPriceListByMap(Map<String, Object> param);

    Integer getDmSchedulerSeatPriceCountByMap(Map<String, Object> param);

    Integer insertDmSchedulerSeatPrice(DmSchedulerSeatPrice dmSchedulerSeatPrice);

    Integer updateDmSchedulerSeatPrice(DmSchedulerSeatPrice dmSchedulerSeatPrice);

    DmSchedulerSeatPrice getDmSchedulerSeatPriceBySchedulerIdAndArea(@Param(value = "areaLevel") Integer areaLevel,
                                                                     @Param(value = "scheduleId") Long scheduleId);
}
