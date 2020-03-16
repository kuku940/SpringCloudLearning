package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmCinema;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmCinemaMapper {

    public DmCinema getDmCinemaById(@Param(value = "id") Long id) throws Exception;

    public List<DmCinema> getDmCinemaListByMap(Map<String, Object> param) throws Exception;

    public Integer getDmCinemaCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertDmCinema(DmCinema dmCinema) throws Exception;

    public Integer updateDmCinema(DmCinema dmCinema) throws Exception;

    public Integer deleteDmCinemaById(@Param(value = "id") Long id) throws Exception;

    public Integer batchDeleteDmCinema(Map<String, List<String>> params);

}
