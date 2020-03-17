package cn.xiaoyu.common.vo;

import lombok.Data;

import java.util.Date;

@Data
public class QueryUserVo {
    private Long id;
    //手机号
    private String phone;
    //真实姓名
    private String realName;
    //昵称
    private String nickName;
    //性别(0:男,1:女)
    private Integer sex;
    //身份证号
    private String idCard;
    //生日
    private Date birthday;
    //兴趣爱好——长字符串
    private String hobby;
    //图片地址
    private String imgUrl;
}
