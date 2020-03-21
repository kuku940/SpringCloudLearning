package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmTradeClientFallBack;
import cn.xiaoyu.common.module.pojo.DmTrade;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-scheduler-provider", configuration = DmConfiguration.class, fallback = DmTradeClientFallBack.class)
public interface RestDmTradeClient {
    @PostMapping(value = "/getDmTradeById")
    DmTrade getDmTradeById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmTradeListByMap")
    List<DmTrade> getDmTradeListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmTradeCountByMap")
    Integer getDmTradeCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmTrade")
    Integer qdtxAddDmTrade(@RequestBody DmTrade dmTrade);

    @PostMapping(value = "/qdtxModifyDmTrade")
    Integer qdtxModifyDmTrade(@RequestBody DmTrade dmTrade);
}

