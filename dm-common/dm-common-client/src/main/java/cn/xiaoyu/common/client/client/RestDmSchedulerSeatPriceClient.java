package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmSchedulerSeatPriceClientFallBack;
import cn.xiaoyu.common.module.pojo.DmSchedulerSeatPrice;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-scheduler-provider", configuration = DmConfiguration.class, fallback = DmSchedulerSeatPriceClientFallBack.class)
public interface RestDmSchedulerSeatPriceClient {
    @PostMapping(value = "/getDmSchedulerSeatPriceById")
    DmSchedulerSeatPrice getDmSchedulerSeatPriceById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmSchedulerSeatPriceListByMap")
    List<DmSchedulerSeatPrice> getDmSchedulerSeatPriceListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmSchedulerSeatPriceCountByMap")
    Integer getDmSchedulerSeatPriceCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmSchedulerSeatPrice")
    Integer qdtxAddDmSchedulerSeatPrice(@RequestBody DmSchedulerSeatPrice dmSchedulerSeatPrice);

    @PostMapping(value = "/qdtxModifyDmSchedulerSeatPrice")
    Integer qdtxModifyDmSchedulerSeatPrice(@RequestBody DmSchedulerSeatPrice dmSchedulerSeatPrice);

    @PostMapping(value = "/getDmSchedulerSeatPriceBySchedulerIdAndArea")
    DmSchedulerSeatPrice getDmSchedulerSeatPriceBySchedulerIdAndArea(@RequestParam(value = "areaLevel") Integer areaLevel,
                                                                     @RequestParam(value = "scheduleId") Long scheduleId);
}

