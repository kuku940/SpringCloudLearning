package cn.xiaoyu.dmbaseprovider.service;

import cn.xiaoyu.common.dao.mapper.DmKeywordSortMapper;
import cn.xiaoyu.common.module.pojo.DmKeywordSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmKeywordSortService {
    @Autowired
    private DmKeywordSortMapper dmKeywordSortMapper;

    @PostMapping(value = "/getDmKeywordSortById")
    public DmKeywordSort getDmKeywordSortById(@RequestParam("id") Long id) {
        return dmKeywordSortMapper.getDmKeywordSortById(id);
    }

    @PostMapping(value = "/getDmKeywordSortListByMap")
    public List<DmKeywordSort> getDmKeywordSortListByMap(@RequestParam Map<String, Object> param) {
        return dmKeywordSortMapper.getDmKeywordSortListByMap(param);
    }

    @PostMapping(value = "/getDmKeywordSortCountByMap")
    public Integer getDmKeywordSortCountByMap(@RequestParam Map<String, Object> param) {
        return dmKeywordSortMapper.getDmKeywordSortCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmKeywordSort")
    public Integer qdtxAddDmKeywordSort(@RequestBody DmKeywordSort dmKeywordSort) {
        dmKeywordSort.setCreatedTime(new Date());
        return dmKeywordSortMapper.insertDmKeywordSort(dmKeywordSort);
    }

    @PostMapping(value = "/qdtxModifyDmKeywordSort")
    public Integer qdtxModifyDmKeywordSort(@RequestBody DmKeywordSort dmKeywordSort) {
        dmKeywordSort.setUpdatedTime(new Date());
        return dmKeywordSortMapper.updateDmKeywordSort(dmKeywordSort);
    }
}
