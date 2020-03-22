package cn.xiaoyu.common.client.client;


import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmUserClientFallBack;
import cn.xiaoyu.common.module.pojo.DmUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmUserClientFallBack.class)
public interface RestDmUserClient {
    @PostMapping(value = "/getDmUserById")
    DmUser getDmUserById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmUserListByMap")
    List<DmUser> getDmUserListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmUserCountByMap")
    Integer getDmUserCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmUser")
    Integer qdtxAddDmUser(@RequestBody DmUser dmUser);

    @PostMapping(value = "/qdtxModifyDmUser")
    Integer qdtxModifyDmUser(@RequestBody DmUser dmUser);

    @PostMapping(value = "/findByWxUserId")
    DmUser findByWxUserId(@RequestParam("wxUserId") String wxUserId);

    @PostMapping(value = "/createuser")
    Long createDmUser(@RequestBody DmUser dmUser);

    @PostMapping(value = "/checkLoginByPassword")
    DmUser checkLoginByPassword(@RequestBody DmUser dmUser);

    @PostMapping(value = "/generateToken")
    String generateToken(@RequestBody DmUser dmUser);
}

