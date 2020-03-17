package cn.xiaoyu.common.vo;

import lombok.Data;

import java.util.Date;

@Data
public class LinkUserVo {
    //对应用户表的主键
    private Long userId;
    //联系人姓名
    private String name;
    //身份证号
    private String idCard;
    //证件类型(0:身份证 1:护照)
    private Integer cardType;
    //创建时间
    private Date createdTime;
    //更新时间
    private Date updatedTime;
}
