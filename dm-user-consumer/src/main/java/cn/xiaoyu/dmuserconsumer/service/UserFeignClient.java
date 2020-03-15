package cn.xiaoyu.dmuserconsumer.service;

import cn.xiaoyu.common.domain.User;
import cn.xiaoyu.dmuserconsumer.service.impl.UserFeignClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "dm-user-provider", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {
    @PostMapping(value = "/login")
    public boolean login(@RequestBody User user);
}
