package cn.xiaoyu.common.vo;

import lombok.Data;

/**
 * 剧评查询VO
 */
@Data
public class ItemCommentVo {
    //商品Id
    private Long itemId;

    //评论用户ID
    private Long userId;

    //评论用户名称
    private String userName;

    //用户头像
    private String imgUrl;

    //评分(1-10)
    private Integer score;

    //剧评
    private String content;

    //更新时间
    private String createdTime;
}
