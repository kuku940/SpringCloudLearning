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

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmSchedulerClientFallBack.class)
public interface RestDmSchedulerClient {
    @PostMapping(value = "/getDmSchedulerById")
    public DmScheduler getDmSchedulerById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmSchedulerListByMap")
    public List<DmScheduler> getDmSchedulerListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmSchedulerCountByMap")
    public Integer getDmSchedulerCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmScheduler")
    public Integer qdtxAddDmScheduler(@RequestBody DmScheduler dmScheduler);

    @PostMapping(value = "/qdtxModifyDmScheduler")
    public Integer qdtxModifyDmScheduler(@RequestBody DmScheduler dmScheduler);
}

