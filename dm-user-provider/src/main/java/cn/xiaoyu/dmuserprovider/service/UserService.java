package cn.xiaoyu.dmuserprovider.service;

import cn.xiaoyu.common.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @PostMapping(value = "/login")
    public boolean login(@RequestBody User user) {
        logger.info("User: {} try login", user.getName());
        return "admin".equals(user.getName()) && "12345".equals(user.getPassword());
    }
}
