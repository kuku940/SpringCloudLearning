package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmLinkUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmLinkUserMapper {

    DmLinkUser getDmLinkUserById(@Param(value = "id") Long id);

    List<DmLinkUser> getDmLinkUserListByMap(Map<String, Object> param);

    Integer getDmLinkUserCountByMap(Map<String, Object> param);

    Integer insertDmLinkUser(DmLinkUser dmLinkUser);

    Integer updateDmLinkUser(DmLinkUser dmLinkUser);

    Integer deleteDmLinkUserById(@Param(value = "id") Long id);

    Integer batchDeleteDmLinkUser(Map<String, List<String>> params);

}
