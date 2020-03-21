package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *   用户表
 */
@Data
public class DmUser implements Serializable {
    //主键
    private Long id;
    //手机号
    private String phone;
    //密码
    private String password;
    //
    private String wxUserId;
    //真实姓名
    private String realName;
    //昵称
    private String nickName;
    //性别(0:男,1:女)
    private Integer sex;
    //兴趣爱好
    private String hobby;
    //身份证号
    private String idCard;
    //生日
    private Date birthday;
    //创建时间
    private Date createdTime;
    //修改时间
    private Date updatedTime;
}
