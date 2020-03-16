package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmLinkUserClientFallBack;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.common.module.pojo.DmLinkUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmLinkUserClientFallBack.class)
public interface RestDmLinkUserClient {
    @PostMapping(value = "/getDmLinkUserById")
    public DmLinkUser getDmLinkUserById(@RequestParam("id") Long id) throws BizException;

    @PostMapping(value = "/getDmLinkUserListByMap")
    public List<DmLinkUser> getDmLinkUserListByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/getDmLinkUserCountByMap")
    public Integer getDmLinkUserCountByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/qdtxAddDmLinkUser")
    public Integer qdtxAddDmLinkUser(@RequestBody DmLinkUser dmLinkUser) throws BizException;

    @PostMapping(value = "/qdtxModifyDmLinkUser")
    public Integer qdtxModifyDmLinkUser(@RequestBody DmLinkUser dmLinkUser) throws BizException;
}

