package cn.xiaoyu.common.client.client;


import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmUserClientFallBack;
import cn.xiaoyu.common.module.pojo.DmUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmUserClientFallBack.class)
public interface RestDmUserClient {
    @PostMapping(value = "/getDmUserById")
    public DmUser getDmUserById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmUserListByMap")
    public List<DmUser> getDmUserListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmUserCountByMap")
    public Integer getDmUserCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmUser")
    public Integer qdtxAddDmUser(@RequestBody DmUser dmUser);

    @PostMapping(value = "/qdtxModifyDmUser")
    public Integer qdtxModifyDmUser(@RequestBody DmUser dmUser);
}

