package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmCinemaSeat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmCinemaSeatMapper {

    DmCinemaSeat getDmCinemaSeatById(@Param(value = "id") Long id);

    List<DmCinemaSeat> getDmCinemaSeatListByMap(Map<String, Object> param);

    Integer getDmCinemaSeatCountByMap(Map<String, Object> param);

    Integer insertDmCinemaSeat(DmCinemaSeat dmCinemaSeat);

    Integer updateDmCinemaSeat(DmCinemaSeat dmCinemaSeat);

    List<String> queryCinemaSeatArray(Map<String, Object> params);
}
