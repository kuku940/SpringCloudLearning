package cn.xiaoyu.dmuserconsumer.controller;

import cn.xiaoyu.common.domain.User;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.dmuserconsumer.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserFeignClient userFeignClient;

    @PostMapping("/user_login")
    public String login(@RequestBody User user) {
        try {
            if (userFeignClient.login(user))
                return "hello, " + user.getName();
            else
                return "username or password wrong";
        } catch (BizException e) {
            return "server busy, try later";
        }
    }
}
