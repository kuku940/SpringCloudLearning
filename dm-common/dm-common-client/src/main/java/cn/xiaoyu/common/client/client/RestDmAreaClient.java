package cn.xiaoyu.common.client.client;


import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmAreaClientFallBack;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.common.module.pojo.DmArea;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-item-provider", configuration = DmConfiguration.class, fallback = DmAreaClientFallBack.class)
public interface RestDmAreaClient {

    @PostMapping(value = "/getDmAreaById")
    public DmArea getDmAreaById(@RequestParam("id") Long id) throws BizException;

    @PostMapping(value = "/getDmAreaListByMap")
    public List<DmArea> getDmAreaListByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/getDmAreaCountByMap")
    public Integer getDmAreaCountByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/qdtxAddDmArea")
    public Integer qdtxAddDmArea(@RequestBody DmArea dmArea) throws BizException;

    @PostMapping(value = "/qdtxModifyDmArea")
    public Integer qdtxModifyDmArea(@RequestBody DmArea dmArea) throws BizException;
}
