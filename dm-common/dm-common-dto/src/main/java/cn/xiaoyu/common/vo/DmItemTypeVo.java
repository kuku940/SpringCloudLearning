package cn.xiaoyu.common.vo;

import lombok.Data;

import java.util.List;

/***`
 * 用于首页数据回传
 */
@Data
public class DmItemTypeVo {
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
    //节目类型集合
    private List<DmItemTypeVo> children;
    //热门节目
    private List<HotItemVo> hotItems;
}
