package cn.xiaoyu.common.vo;

import lombok.Data;

import java.util.List;

/**
 * 按月份组装数据
 */
@Data
public class MonthVo {
    //当前日期（天）
    private String day;
    //当前日期的节目列表
    private List<ParentAndChildVo> itemList;
}
