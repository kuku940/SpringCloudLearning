package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmLinkUserClientFallBack;
import cn.xiaoyu.common.module.pojo.DmLinkUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmLinkUserClientFallBack.class)
public interface RestDmLinkUserClient {
    @PostMapping(value = "/getDmLinkUserById")
    DmLinkUser getDmLinkUserById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmLinkUserListByMap")
    List<DmLinkUser> getDmLinkUserListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmLinkUserCountByMap")
    Integer getDmLinkUserCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmLinkUser")
    Integer qdtxAddDmLinkUser(@RequestBody DmLinkUser dmLinkUser);

    @PostMapping(value = "/qdtxModifyDmLinkUser")
    Integer qdtxModifyDmLinkUser(@RequestBody DmLinkUser dmLinkUser);

    @PostMapping(value = "/deleteDmLinkUserById")
    Integer deleteDmLinkUserById(@RequestParam("id") Long id);
}

