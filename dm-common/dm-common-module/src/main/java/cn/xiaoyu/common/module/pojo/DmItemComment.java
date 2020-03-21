package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/***
 *   剧评表
 */
@Data
public class DmItemComment implements Serializable {
    //
    private Long id;
    //剧目Id
    private Long itemId;
    //评论用户ID
    private Long userId;
    //评分(1-10)
    private Integer score;
    //剧评
    private String content;
    //更新时间
    private Date createdTime;
    //修改时间
    private Date updatedTime;
}
