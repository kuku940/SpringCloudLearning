package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmRegisterClientFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmRegisterClientFallBack.class)
public interface RestDmRegisterClient {
    /**
     * 生成注册验证码
     *
     * @return 注册验证码
     */
    @PostMapping(value = "/generateVerificationCode")
    String generateVerificationCode();
}

