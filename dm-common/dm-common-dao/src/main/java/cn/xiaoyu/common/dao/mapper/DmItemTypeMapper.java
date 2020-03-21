package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmItemType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmItemTypeMapper {
    DmItemType getDmItemTypeById(@Param(value = "id") Long id);

    List<DmItemType> getDmItemTypeListByMap(Map<String, Object> param);

    Integer getDmItemTypeCountByMap(Map<String, Object> param);

    Integer insertDmItemType(DmItemType dmItemType);

    Integer updateDmItemType(DmItemType dmItemType);
}
