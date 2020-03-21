package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmOrderClientFallBack;
import cn.xiaoyu.common.module.pojo.DmOrder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-order-provider", configuration = DmConfiguration.class, fallback = DmOrderClientFallBack.class)
public interface RestDmOrderClient {
    @PostMapping(value = "/getDmOrderById")
    public DmOrder getDmOrderById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmOrderListByMap")
    public List<DmOrder> getDmOrderListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmOrderCountByMap")
    public Integer getDmOrderCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmOrder")
    public Integer qdtxAddDmOrder(@RequestBody DmOrder dmOrder);

    @PostMapping(value = "/qdtxModifyDmOrder")
    public Integer qdtxModifyDmOrder(@RequestBody DmOrder dmOrder);
}

