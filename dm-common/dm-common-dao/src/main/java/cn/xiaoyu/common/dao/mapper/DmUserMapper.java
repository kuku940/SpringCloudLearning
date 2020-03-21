package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmUserMapper {
    DmUser getDmUserById(@Param(value = "id") Long id);

    List<DmUser> getDmUserListByMap(Map<String, Object> param);

    Integer getDmUserCountByMap(Map<String, Object> param);

    Integer insertDmUser(DmUser dmUser);

    Integer updateDmUser(DmUser dmUser);
}
