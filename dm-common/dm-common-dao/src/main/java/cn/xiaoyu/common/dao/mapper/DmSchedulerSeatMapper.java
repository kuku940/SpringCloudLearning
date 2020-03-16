package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmSchedulerSeat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmSchedulerSeatMapper {

    DmSchedulerSeat getDmSchedulerSeatById(@Param(value = "id") Long id);

    List<DmSchedulerSeat> getDmSchedulerSeatListByMap(Map<String, Object> param);

    Integer getDmSchedulerSeatCountByMap(Map<String, Object> param);

    Integer insertDmSchedulerSeat(DmSchedulerSeat dmSchedulerSeat);

    Integer updateDmSchedulerSeat(DmSchedulerSeat dmSchedulerSeat);

    Integer deleteDmSchedulerSeatById(@Param(value = "id") Long id);

    Integer batchDeleteDmSchedulerSeat(Map<String, List<String>> params);

}
