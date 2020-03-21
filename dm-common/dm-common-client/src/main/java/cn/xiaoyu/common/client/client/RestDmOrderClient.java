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
    DmOrder getDmOrderById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmOrderListByMap")
    List<DmOrder> getDmOrderListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmOrderCountByMap")
    Integer getDmOrderCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmOrder")
    Integer qdtxAddDmOrder(@RequestBody DmOrder dmOrder);

    @PostMapping(value = "/qdtxModifyDmOrder")
    Integer qdtxModifyDmOrder(@RequestBody DmOrder dmOrder);

    @PostMapping(value = "/getDmOrderListByOrderNoOrDate")
    List<DmOrder> getDmOrderListByOrderNoOrDate(@RequestBody Map<String, Object> param);

    @PostMapping(value = "/getDmOrderByOrderNo")
    DmOrder getDmOrderByOrderNo(@RequestParam("orderNo") String orderNo);

    @PostMapping(value = "/deleteDmOrderById")
    Integer deleteDmOrderById(@RequestParam("id") Long id);

    @PostMapping(value = "/flushCancelOrderType")
    boolean flushCancelOrderType();

    @PostMapping(value = "/getDmOrderByOrderTypeAndTime")
    List<DmOrder> getDmOrderByOrderTypeAndTime();

    @PostMapping(value = "/processed")
    boolean processed(@RequestParam("orderNo") String orderNo, @RequestParam("flag") Integer flag);
}

