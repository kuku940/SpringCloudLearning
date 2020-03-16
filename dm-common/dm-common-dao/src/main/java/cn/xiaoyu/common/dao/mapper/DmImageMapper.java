package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmImageMapper {

    DmImage getDmImageById(@Param(value = "id") Long id);

    List<DmImage> getDmImageListByMap(Map<String, Object> param);

    Integer getDmImageCountByMap(Map<String, Object> param);

    Integer insertDmImage(DmImage dmImage);

    Integer updateDmImage(DmImage dmImage);

    Integer deleteDmImageById(@Param(value = "id") Long id);

    Integer batchDeleteDmImage(Map<String, List<String>> params);
}
