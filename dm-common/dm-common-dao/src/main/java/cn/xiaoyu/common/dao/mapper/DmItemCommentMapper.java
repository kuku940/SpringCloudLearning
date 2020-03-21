package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmItemComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmItemCommentMapper {

    DmItemComment getDmItemCommentById(@Param(value = "id") Long id);

    List<DmItemComment> getDmItemCommentListByMap(Map<String, Object> param);

    Integer getDmItemCommentCountByMap(Map<String, Object> param);

    Integer insertDmItemComment(DmItemComment dmItemComment);

    Integer updateDmItemComment(DmItemComment dmItemComment);
}
