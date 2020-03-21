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

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmSchedulerSeatPriceClientFallBack.class)
public interface RestDmSchedulerSeatPriceClient {
    @PostMapping(value = "/getDmSchedulerSeatPriceById")
    public DmSchedulerSeatPrice getDmSchedulerSeatPriceById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmSchedulerSeatPriceListByMap")
    public List<DmSchedulerSeatPrice> getDmSchedulerSeatPriceListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmSchedulerSeatPriceCountByMap")
    public Integer getDmSchedulerSeatPriceCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmSchedulerSeatPrice")
    public Integer qdtxAddDmSchedulerSeatPrice(@RequestBody DmSchedulerSeatPrice dmSchedulerSeatPrice);

    @PostMapping(value = "/qdtxModifyDmSchedulerSeatPrice")
    public Integer qdtxModifyDmSchedulerSeatPrice(@RequestBody DmSchedulerSeatPrice dmSchedulerSeatPrice);
}

