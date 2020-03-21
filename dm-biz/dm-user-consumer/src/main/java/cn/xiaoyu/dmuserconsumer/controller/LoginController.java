package cn.xiaoyu.dmuserconsumer.controller;

import cn.xiaoyu.common.client.client.RestDmUserClient;
import cn.xiaoyu.common.module.pojo.DmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private RestDmUserClient restDmUserClient;

    @PostMapping("/user_login")
    public String login(@RequestBody Long userId) {
        try {
            DmUser dmUser = restDmUserClient.getDmUserById(userId);
            if (dmUser != null)
                return "hello, " + dmUser.getNickName();
            else
                return "username or password wrong";
        } catch (Exception e) {
            return "server busy, try later";
        }
    }
}
