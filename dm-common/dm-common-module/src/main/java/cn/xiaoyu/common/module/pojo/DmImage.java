package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/***
 *   图片表
 */
@Data
public class DmImage implements Serializable {
    //
    private Long id;
    //图片URL
    private String imgUrl;
    //关联表ID
    private Integer targetId;
    //顺序
    private Integer sort;
    //图片类型（0:无类型 1:轮播图 2:海报图）
    private Integer type;
    //图片分类（0：用户头像 1：商品图片）
    private Integer category;
    //创建时间
    private Date createdTime;
    //更新时间
    private Date updatedTime;
}
