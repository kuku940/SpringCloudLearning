package cn.xiaoyu.common.client.client;


import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmUserClientFallBack;
import cn.xiaoyu.common.module.pojo.DmUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmUserClientFallBack.class)
public interface RestDmUserClient {
    @RequestMapping(value = "/getDmUserById", method = RequestMethod.POST)
    public DmUser getDmUserById(@RequestParam("id") Long id) throws Exception;

    @RequestMapping(value = "/getDmUserListByMap", method = RequestMethod.POST)
    public List<DmUser> getDmUserListByMap(@RequestParam Map<String, Object> param) throws Exception;

    @RequestMapping(value = "/getDmUserCountByMap", method = RequestMethod.POST)
    public Integer getDmUserCountByMap(@RequestParam Map<String, Object> param) throws Exception;

    @RequestMapping(value = "/qdtxAddDmUser", method = RequestMethod.POST)
    public Integer qdtxAddDmUser(@RequestBody DmUser dmUser) throws Exception;

    @RequestMapping(value = "/qdtxModifyDmUser", method = RequestMethod.POST)
    public Integer qdtxModifyDmUser(@RequestBody DmUser dmUser) throws Exception;
}

