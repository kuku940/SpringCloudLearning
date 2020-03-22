package cn.xiaoyu.dmuserconsumer.controller;

import cn.xiaoyu.common.common.Dto;
import cn.xiaoyu.common.common.DtoUtil;
import cn.xiaoyu.common.module.pojo.DmUser;
import cn.xiaoyu.common.utils.EmptyUtils;
import cn.xiaoyu.common.utils.MD5;
import cn.xiaoyu.dmuserconsumer.service.DmLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DmUserController {
    @Autowired
    private DmLoginService dmLoginService;

    @PostMapping(value = "/p/login")
    public Dto loginByPassword(@RequestBody DmUser dmUser) {
        dmUser.setPassword(MD5.getMd5(dmUser.getPassword(), 32));
        Object[] results = dmLoginService.login(dmUser);
        if (EmptyUtils.isEmpty(results)) {
            return DtoUtil.returnFail("登陆失败", "0000");
        } else {
            return DtoUtil.returnSuccess("登陆成功", results);
        }
    }
}
