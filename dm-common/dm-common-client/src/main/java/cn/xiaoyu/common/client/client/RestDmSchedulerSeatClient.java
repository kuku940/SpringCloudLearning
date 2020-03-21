package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmSchedulerSeatClientFallBack;
import cn.xiaoyu.common.module.pojo.DmSchedulerSeat;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-scheduler-provider", configuration = DmConfiguration.class, fallback = DmSchedulerSeatClientFallBack.class)
public interface RestDmSchedulerSeatClient {
    @PostMapping(value = "/getDmSchedulerSeatById")
    DmSchedulerSeat getDmSchedulerSeatById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmSchedulerSeatListByMap")
    List<DmSchedulerSeat> getDmSchedulerSeatListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmSchedulerSeatCountByMap")
    Integer getDmSchedulerSeatCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmSchedulerSeat")
    Integer qdtxAddDmSchedulerSeat(@RequestBody DmSchedulerSeat dmSchedulerSeat);

    @PostMapping(value = "/qdtxModifyDmSchedulerSeat")
    Integer qdtxModifyDmSchedulerSeat(@RequestBody DmSchedulerSeat dmSchedulerSeat);

    @PostMapping(value = "/getDmSchedulerSeatByOrder")
    DmSchedulerSeat getDmSchedulerSeatByOrder(@RequestParam(value = "scheduleId") Long scheduleId,
                                              @RequestParam(value = "x") Integer x,
                                              @RequestParam(value = "y") Integer y);
}

