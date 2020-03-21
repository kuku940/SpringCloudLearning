package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *   热门关键词排序表
 */
@Data
public class DmKeywordSort implements Serializable {
    //
    private Long id;
    //搜索关键词
    private String keyword;
    //搜索数目
    private Integer count;
    //
    private Date createdTime;
    //
    private Date updatedTime;
}
