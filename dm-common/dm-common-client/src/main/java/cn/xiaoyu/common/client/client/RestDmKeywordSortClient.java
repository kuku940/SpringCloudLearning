package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmKeywordSortClientFallBack;
import cn.xiaoyu.common.module.pojo.DmKeywordSort;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-base-provider", configuration = DmConfiguration.class, fallback = DmKeywordSortClientFallBack.class)
public interface RestDmKeywordSortClient {

    @PostMapping(value = "/getDmKeywordSortById")
    DmKeywordSort getDmKeywordSortById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmKeywordSortListByMap")
    List<DmKeywordSort> getDmKeywordSortListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmKeywordSortCountByMap")
    Integer getDmKeywordSortCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmKeywordSort")
    Integer qdtxAddDmKeywordSort(@RequestBody DmKeywordSort dmKeywordSort);

    @PostMapping(value = "/qdtxModifyDmKeywordSort")
    Integer qdtxModifyDmKeywordSort(@RequestBody DmKeywordSort dmKeywordSort);
}
