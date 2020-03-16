package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmTradeClientFallBack;
import cn.xiaoyu.common.module.pojo.DmTrade;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-scheduler-provider", configuration = DmConfiguration.class, fallback = DmTradeClientFallBack.class)
public interface RestDmTradeClient {
    @RequestMapping(value = "/getDmTradeById", method = RequestMethod.POST)
    public DmTrade getDmTradeById(@RequestParam("id") Long id) throws Exception;

    @RequestMapping(value = "/getDmTradeListByMap", method = RequestMethod.POST)
    public List<DmTrade> getDmTradeListByMap(@RequestParam Map<String, Object> param) throws Exception;

    @RequestMapping(value = "/getDmTradeCountByMap", method = RequestMethod.POST)
    public Integer getDmTradeCountByMap(@RequestParam Map<String, Object> param) throws Exception;

    @RequestMapping(value = "/qdtxAddDmTrade", method = RequestMethod.POST)
    public Integer qdtxAddDmTrade(@RequestBody DmTrade dmTrade) throws Exception;

    @RequestMapping(value = "/qdtxModifyDmTrade", method = RequestMethod.POST)
    public Integer qdtxModifyDmTrade(@RequestBody DmTrade dmTrade) throws Exception;
}

