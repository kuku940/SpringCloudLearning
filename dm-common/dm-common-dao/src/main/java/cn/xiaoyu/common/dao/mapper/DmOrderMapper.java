package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmOrderMapper {

    DmOrder getDmOrderById(@Param(value = "id") Long id);

    List<DmOrder> getDmOrderListByMap(Map<String, Object> param);

    Integer getDmOrderCountByMap(Map<String, Object> param);

    Integer insertDmOrder(DmOrder dmOrder);

    Integer updateDmOrder(DmOrder dmOrder);

    Integer deleteDmOrderById(@Param(value = "id") Long id);

    Integer batchDeleteDmOrder(Map<String, List<String>> params);

}
