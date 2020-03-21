package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmTrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmTradeMapper {
    DmTrade getDmTradeById(@Param(value = "id") Long id);

    List<DmTrade> getDmTradeListByMap(Map<String, Object> param);

    Integer getDmTradeCountByMap(Map<String, Object> param);

    Integer insertDmTrade(DmTrade dmTrade);

    Integer updateDmTrade(DmTrade dmTrade);
}
