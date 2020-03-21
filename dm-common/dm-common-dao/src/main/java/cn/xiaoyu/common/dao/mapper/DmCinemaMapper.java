package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmCinema;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmCinemaMapper {

    DmCinema getDmCinemaById(@Param(value = "id") Long id);

    List<DmCinema> getDmCinemaListByMap(Map<String, Object> param);

    Integer getDmCinemaCountByMap(Map<String, Object> param);

    Integer insertDmCinema(DmCinema dmCinema);

    Integer updateDmCinema(DmCinema dmCinema);
}
