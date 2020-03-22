package cn.xiaoyu.dmuserprovider.service;

import cn.xiaoyu.common.module.pojo.DmUser;
import cn.xiaoyu.common.utils.EmptyUtils;
import cn.xiaoyu.common.utils.MD5;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Token管理服务
 */
@RestController
public class RestDmTokenService {
    private static final String TOKEN_PREFIX = "token";

    @PostMapping(value = "/generateToken")
    public String generateToken(@RequestBody DmUser dmUser) {
        StringBuilder sb = new StringBuilder();
        sb.append(TOKEN_PREFIX + "-");
        sb.append("PC-" + "-");
        String info = MD5.getMd5(EmptyUtils.isEmpty(dmUser.getPhone()) ? dmUser.getWxUserId() : dmUser.getPhone(), 32);
        sb.append(info + "-");
        sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "-");
        sb.append(UUID.randomUUID().toString().substring(0, 6));
        return sb.toString();
    }
}
