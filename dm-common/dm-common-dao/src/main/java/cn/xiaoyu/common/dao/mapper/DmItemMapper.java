package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmItemMapper {

    DmItem getDmItemById(@Param(value = "id") Long id);

    List<DmItem> getDmItemListByMap(Map<String, Object> param);

    Integer getDmItemCountByMap(Map<String, Object> param);

    Integer insertDmItem(DmItem dmItem);

    Integer updateDmItem(DmItem dmItem);

    List<DmItem> getHotDmItemList(Map<String, Object> param);

    List<DmItem> getItemByMonth(Map<String, Object> params);

    List<DmItem> getHotDmItemListForEs(Map<String, Object> param);
}
