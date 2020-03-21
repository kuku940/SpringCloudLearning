package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmScheduler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmSchedulerMapper {

    DmScheduler getDmSchedulerById(@Param(value = "id") Long id);

    List<DmScheduler> getDmSchedulerListByMap(Map<String, Object> param);

    Integer getDmSchedulerCountByMap(Map<String, Object> param);

    Integer insertDmScheduler(DmScheduler dmScheduler);

    Integer updateDmScheduler(DmScheduler dmScheduler);
}
