package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *   区域表
 */
@Data
public class DmArea implements Serializable {
    //
    private Long id;
    //区域名称
    private String name;
    //父级区域
    private String parent;
    //分类级别;select;(0:全国,1:1级,2:2级)
    private Integer level;
    //是否是热门城市(0:不是,1:是)
    private Integer isHot;
    //创建时间
    private Date createdTime;
    //更新时间
    private Date updatedTime;
}
