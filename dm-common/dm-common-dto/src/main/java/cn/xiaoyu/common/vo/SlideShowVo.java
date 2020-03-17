package cn.xiaoyu.common.vo;

import lombok.Data;

/**
 * 亲子页轮播图
 */
@Data
public class SlideShowVo {
    //商品主键
    private Long id;
    //节目名称
    private String itemName;
    //最低价格
    private Double minPrice;
    //热门节目宣传照片
    private String imgUrl;
}
