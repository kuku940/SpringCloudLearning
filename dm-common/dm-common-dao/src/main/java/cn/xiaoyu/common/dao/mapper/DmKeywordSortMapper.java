package cn.xiaoyu.common.dao.mapper;

import cn.xiaoyu.common.module.pojo.DmKeywordSort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmKeywordSortMapper {

    public DmKeywordSort getDmKeywordSortById(@Param(value = "id") Long id) throws Exception;

    public List<DmKeywordSort> getDmKeywordSortListByMap(Map<String, Object> param) throws Exception;

    public Integer getDmKeywordSortCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertDmKeywordSort(DmKeywordSort dmKeywordSort) throws Exception;

    public Integer updateDmKeywordSort(DmKeywordSort dmKeywordSort) throws Exception;

    public Integer deleteDmKeywordSortById(@Param(value = "id") Long id) throws Exception;

    public Integer batchDeleteDmKeywordSort(Map<String, List<String>> params);

}
