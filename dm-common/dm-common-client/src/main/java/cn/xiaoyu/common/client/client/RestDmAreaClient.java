package cn.xiaoyu.common.client.client;


import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmAreaClientFallBack;
import cn.xiaoyu.common.module.pojo.DmArea;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-base-provider", configuration = DmConfiguration.class, fallback = DmAreaClientFallBack.class)
public interface RestDmAreaClient {

    @PostMapping(value = "/getDmAreaById")
    DmArea getDmAreaById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmAreaListByMap")
    List<DmArea> getDmAreaListByMap(@RequestBody Map<String, Object> param);

    @PostMapping(value = "/getDmAreaCountByMap")
    Integer getDmAreaCountByMap(@RequestBody Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmArea")
    Integer qdtxAddDmArea(@RequestBody DmArea dmArea);

    @PostMapping(value = "/qdtxModifyDmArea")
    Integer qdtxModifyDmArea(@RequestBody DmArea dmArea);
}
