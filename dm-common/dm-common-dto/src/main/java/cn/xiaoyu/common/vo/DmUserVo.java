package cn.xiaoyu.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *   用户信息
 */
@Data
public class DmUserVo implements Serializable {
    //用户ID
    private Long userId;
    //手机号
    private String phone;
    //
    private String wxUserId;
    //真实姓名
    private String realName;
    //昵称
    private String nickName;
    //性别(0:男,1:女)
    private Integer sex;
    //身份证号
    private String idCard;
    //生日
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date birthday;
    //创建时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    //更新时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
    // 兴趣爱好
    private String hobby;

    // 头像图片ID
    private Long imageId;
    // 图片URL
    private String imgUrl;
    //微信用户头像
    private String headimgUrl;
}
