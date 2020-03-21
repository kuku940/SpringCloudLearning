package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/***
 *   常用联系人表
 */
@Data
public class DmLinkUser implements Serializable {
    //
    private Long id;
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
    //修改时间
    private Date updatedTime;
}
