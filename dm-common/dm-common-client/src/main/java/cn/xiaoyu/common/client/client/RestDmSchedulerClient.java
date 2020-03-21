package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmSchedulerClientFallBack;
import cn.xiaoyu.common.module.pojo.DmScheduler;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-scheduler-provider", configuration = DmConfiguration.class, fallback = DmSchedulerClientFallBack.class)
public interface RestDmSchedulerClient {
    @PostMapping(value = "/getDmSchedulerById")
    DmScheduler getDmSchedulerById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmSchedulerListByMap")
    List<DmScheduler> getDmSchedulerListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmSchedulerCountByMap")
    Integer getDmSchedulerCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmScheduler")
    Integer qdtxAddDmScheduler(@RequestBody DmScheduler dmScheduler);

    @PostMapping(value = "/qdtxModifyDmScheduler")
    Integer qdtxModifyDmScheduler(@RequestBody DmScheduler dmScheduler);

    @PostMapping(value = "/getDmSchedulerByItemId")
    DmScheduler getDmSchedulerByItemId(@RequestParam("itemId") Long itemId);
}

