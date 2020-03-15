package cn.xiaoyu.dmuserconsumer.service.impl;

import cn.xiaoyu.common.domain.User;
import cn.xiaoyu.dmuserconsumer.service.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient {
    private static final Logger logger = LoggerFactory.getLogger(UserFeignClientFallback.class);

    @Override
    public boolean login(User user) {
        logger.info("UserFeignClientFallback invoked");
        return false;
    }
}
