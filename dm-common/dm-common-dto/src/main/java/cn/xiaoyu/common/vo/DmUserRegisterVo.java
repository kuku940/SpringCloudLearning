package cn.xiaoyu.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 *   用户表
 */
@Data
public class DmUserRegisterVo implements Serializable {
    //手机号
    private String phone;
    //密码
    private String password;
    // 验证码
    private String vcode;
}
