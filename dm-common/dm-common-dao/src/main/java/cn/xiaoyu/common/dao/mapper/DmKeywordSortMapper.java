package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmKeywordSort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmKeywordSortMapper {

    DmKeywordSort getDmKeywordSortById(@Param(value = "id") Long id);

    List<DmKeywordSort> getDmKeywordSortListByMap(Map<String, Object> param);

    Integer getDmKeywordSortCountByMap(Map<String, Object> param);

    Integer insertDmKeywordSort(DmKeywordSort dmKeywordSort);

    Integer updateDmKeywordSort(DmKeywordSort dmKeywordSort);

    Integer deleteDmKeywordSortById(@Param(value = "id") Long id);

    Integer batchDeleteDmKeywordSort(Map<String, List<String>> params);

}
