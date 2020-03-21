package cn.xiaoyu.common.client.client;


import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmCinemaSeatClientFallBack;
import cn.xiaoyu.common.module.pojo.DmCinemaSeat;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmCinemaSeatClientFallBack.class)
public interface RestDmCinemaSeatClient {
    @PostMapping(value = "/getDmCinemaSeatById")
    DmCinemaSeat getDmCinemaSeatById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmCinemaSeatListByMap")
    List<DmCinemaSeat> getDmCinemaSeatListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmCinemaSeatCountByMap")
    Integer getDmCinemaSeatCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmCinemaSeat")
    Integer qdtxAddDmCinemaSeat(@RequestBody DmCinemaSeat dmCinemaSeat);

    @PostMapping(value = "/qdtxModifyDmCinemaSeat")
    Integer qdtxModifyDmCinemaSeat(@RequestBody DmCinemaSeat dmCinemaSeat);

    @PostMapping(value = "/queryCinemaSeatArray")
    List<String> queryCinemaSeatArray(@RequestBody Map<String, Object> params);
}

