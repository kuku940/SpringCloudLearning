package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmAreaMapper {

    DmArea getDmAreaById(@Param(value = "id") Long id);

    List<DmArea> getDmAreaListByMap(Map<String, Object> param);

    Integer getDmAreaCountByMap(Map<String, Object> param);

    Integer insertDmArea(DmArea dmArea);

    Integer updateDmArea(DmArea dmArea);

    Integer deleteDmAreaById(@Param(value = "id") Long id);

    Integer batchDeleteDmArea(Map<String, List<String>> params);

}
