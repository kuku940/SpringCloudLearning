package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmAreaMapper {

    public DmArea getDmAreaById(@Param(value = "id") Long id) throws Exception;

    public List<DmArea> getDmAreaListByMap(Map<String, Object> param) throws Exception;

    public Integer getDmAreaCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertDmArea(DmArea dmArea) throws Exception;

    public Integer updateDmArea(DmArea dmArea) throws Exception;

    public Integer deleteDmAreaById(@Param(value = "id") Long id) throws Exception;

    public Integer batchDeleteDmArea(Map<String, List<String>> params);

}
