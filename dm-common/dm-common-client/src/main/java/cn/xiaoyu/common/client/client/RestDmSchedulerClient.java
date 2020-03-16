package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmSchedulerClientFallBack;
import cn.xiaoyu.common.module.pojo.DmScheduler;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmSchedulerClientFallBack.class)
public interface RestDmSchedulerClient {
    @RequestMapping(value = "/getDmSchedulerById", method = RequestMethod.POST)
    public DmScheduler getDmSchedulerById(@RequestParam("id") Long id) throws Exception;

    @RequestMapping(value = "/getDmSchedulerListByMap", method = RequestMethod.POST)
    public List<DmScheduler> getDmSchedulerListByMap(@RequestParam Map<String, Object> param) throws Exception;

    @RequestMapping(value = "/getDmSchedulerCountByMap", method = RequestMethod.POST)
    public Integer getDmSchedulerCountByMap(@RequestParam Map<String, Object> param) throws Exception;

    @RequestMapping(value = "/qdtxAddDmScheduler", method = RequestMethod.POST)
    public Integer qdtxAddDmScheduler(@RequestBody DmScheduler dmScheduler) throws Exception;

    @RequestMapping(value = "/qdtxModifyDmScheduler", method = RequestMethod.POST)
    public Integer qdtxModifyDmScheduler(@RequestBody DmScheduler dmScheduler) throws Exception;
}
