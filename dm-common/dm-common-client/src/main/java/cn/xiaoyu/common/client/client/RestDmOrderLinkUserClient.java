package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmOrderLinkUserClientFallBack;
import cn.xiaoyu.common.module.pojo.DmOrderLinkUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-order-provider", configuration = DmConfiguration.class, fallback = DmOrderLinkUserClientFallBack.class)
public interface RestDmOrderLinkUserClient {
    @PostMapping(value = "/getDmOrderLinkUserById")
    DmOrderLinkUser getDmOrderLinkUserById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmOrderLinkUserListByMap")
    List<DmOrderLinkUser> getDmOrderLinkUserListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmOrderLinkUserCountByMap")
    Integer getDmOrderLinkUserCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmOrderLinkUser")
    Integer qdtxAddDmOrderLinkUser(@RequestBody DmOrderLinkUser dmOrderLinkUser);

    @PostMapping(value = "/qdtxModifyDmOrderLinkUser")
    Integer qdtxModifyDmOrderLinkUser(@RequestBody DmOrderLinkUser dmOrderLinkUser);

    @PostMapping(value = "/deleteDmOrderLinkUserByOrderId")
    Integer deleteDmOrderLinkUserByOrderId(@RequestParam("orderId") Long orderId);
}

