package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *   节目类型表
 */
@Data
public class DmItemType implements Serializable {
    //主键
    private Long id;
    //类型名称
    private String itemType;
    //分类级别;select;(1:1级,2:2级)
    private String level;
    //父级类型
    private Long parent;
    //类别别名
    private String aliasName;
    //页面模板类型
    private String key;
    //创建时间
    private Date createdTime;
    //更新时间
    private Date updatedTime;
}
