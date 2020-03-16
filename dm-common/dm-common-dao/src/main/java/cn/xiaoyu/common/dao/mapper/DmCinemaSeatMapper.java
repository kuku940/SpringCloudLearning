package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmCinemaSeat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmCinemaSeatMapper {

    public DmCinemaSeat getDmCinemaSeatById(@Param(value = "id") Long id) throws Exception;

    public List<DmCinemaSeat> getDmCinemaSeatListByMap(Map<String, Object> param) throws Exception;

    public Integer getDmCinemaSeatCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertDmCinemaSeat(DmCinemaSeat dmCinemaSeat) throws Exception;

    public Integer updateDmCinemaSeat(DmCinemaSeat dmCinemaSeat) throws Exception;

    public Integer deleteDmCinemaSeatById(@Param(value = "id") Long id) throws Exception;

    public Integer batchDeleteDmCinemaSeat(Map<String, List<String>> params);

}
