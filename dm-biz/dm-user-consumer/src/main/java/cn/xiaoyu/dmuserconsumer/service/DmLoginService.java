package cn.xiaoyu.dmuserconsumer.service;

import cn.xiaoyu.common.module.pojo.DmUser;
import cn.xiaoyu.common.vo.DmUserVo;

public interface DmLoginService {
    /**
     * 账号密码登陆
     */
    Object[] login(DmUser dmUser);

    /**
     * 根据token获取当前登陆的用户信息
     */
    DmUserVo loadCurrentUserByTokenAsDmUserVo(String tokenString);
}
