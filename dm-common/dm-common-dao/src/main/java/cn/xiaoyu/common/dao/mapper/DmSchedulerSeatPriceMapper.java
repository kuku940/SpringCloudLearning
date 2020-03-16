package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmSchedulerSeatPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmSchedulerSeatPriceMapper {

    public DmSchedulerSeatPrice getDmSchedulerSeatPriceById(@Param(value = "id") Long id) throws Exception;

    public List<DmSchedulerSeatPrice> getDmSchedulerSeatPriceListByMap(Map<String, Object> param) throws Exception;

    public Integer getDmSchedulerSeatPriceCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertDmSchedulerSeatPrice(DmSchedulerSeatPrice dmSchedulerSeatPrice) throws Exception;

    public Integer updateDmSchedulerSeatPrice(DmSchedulerSeatPrice dmSchedulerSeatPrice) throws Exception;

    public Integer deleteDmSchedulerSeatPriceById(@Param(value = "id") Long id) throws Exception;

    public Integer batchDeleteDmSchedulerSeatPrice(Map<String, List<String>> params);

}
