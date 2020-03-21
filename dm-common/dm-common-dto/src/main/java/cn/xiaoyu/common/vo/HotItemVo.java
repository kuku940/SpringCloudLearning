package cn.xiaoyu.common.vo;

import lombok.Data;

/**
 * 热门节目数据传递VO
 */
@Data
public class HotItemVo {
    //主键id
    private Long id;
    //节目名称
    private String itemName;
    //最低价格
    private Double minPrice;
    //图片地址
    private String imgUrl;
}
