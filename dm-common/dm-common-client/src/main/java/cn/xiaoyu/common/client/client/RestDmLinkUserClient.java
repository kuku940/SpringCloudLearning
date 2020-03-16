package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmLinkUserClientFallBack;
import cn.xiaoyu.common.module.pojo.DmLinkUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmLinkUserClientFallBack.class)
public interface RestDmLinkUserClient {
    @RequestMapping(value = "/getDmLinkUserById", method = RequestMethod.POST)
    public DmLinkUser getDmLinkUserById(@RequestParam("id") Long id) throws Exception;

    @RequestMapping(value = "/getDmLinkUserListByMap", method = RequestMethod.POST)
    public List<DmLinkUser> getDmLinkUserListByMap(@RequestParam Map<String, Object> param) throws Exception;

    @RequestMapping(value = "/getDmLinkUserCountByMap", method = RequestMethod.POST)
    public Integer getDmLinkUserCountByMap(@RequestParam Map<String, Object> param) throws Exception;

    @RequestMapping(value = "/qdtxAddDmLinkUser", method = RequestMethod.POST)
    public Integer qdtxAddDmLinkUser(@RequestBody DmLinkUser dmLinkUser) throws Exception;

    @RequestMapping(value = "/qdtxModifyDmLinkUser", method = RequestMethod.POST)
    public Integer qdtxModifyDmLinkUser(@RequestBody DmLinkUser dmLinkUser) throws Exception;
}

