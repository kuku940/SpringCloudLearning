package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmOrderLinkUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmOrderLinkUserMapper {

    DmOrderLinkUser getDmOrderLinkUserById(@Param(value = "id") Long id);

    List<DmOrderLinkUser> getDmOrderLinkUserListByMap(Map<String, Object> param);

    Integer getDmOrderLinkUserCountByMap(Map<String, Object> param);

    Integer insertDmOrderLinkUser(DmOrderLinkUser dmOrderLinkUser);

    Integer updateDmOrderLinkUser(DmOrderLinkUser dmOrderLinkUser);

    Integer deleteDmOrderLinkUserById(@Param(value = "id") Long id);

    Integer batchDeleteDmOrderLinkUser(Map<String, List<String>> params);

}
