package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmTrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmTradeMapper {

    public DmTrade getDmTradeById(@Param(value = "id") Long id) throws Exception;

    public List<DmTrade> getDmTradeListByMap(Map<String, Object> param) throws Exception;

    public Integer getDmTradeCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertDmTrade(DmTrade dmTrade) throws Exception;

    public Integer updateDmTrade(DmTrade dmTrade) throws Exception;

    public Integer deleteDmTradeById(@Param(value = "id") Long id) throws Exception;

    public Integer batchDeleteDmTrade(Map<String, List<String>> params);

}