package cn.xiaoyu.dmitemconsumer.service;

import cn.xiaoyu.common.module.pojo.DmItem;
import cn.xiaoyu.common.module.pojo.DmItemType;
import cn.xiaoyu.common.vo.DmFloorItems;
import cn.xiaoyu.common.vo.DmItemTypeVo;
import cn.xiaoyu.common.vo.HotItemVo;

import java.util.List;

/**
 * 处理首页业务逻辑的service
 */
public interface HomeService {
    /**
     * 获取首页所有的商品分类
     */
    List<DmItemTypeVo> queryAllItemType();

    /**
     * 获取横向导航条
     */
    List<DmItemType> queryTransverse();

    /**
     * 查询首页轮播图
     */
    List<HotItemVo> queryBanner();

    /**
     * 查询即将开售接口
     */
    List<HotItemVo> queryToSaleItem();

    /**
     * 查询今日推荐接口
     */
    List<HotItemVo> queryTodayRecommend();

    /**
     * 查询不同楼层的数据
     */
    List<DmFloorItems> queryFloorItems();

    /**
     * 查询热门节目
     */
    List<HotItemVo> queryHotItems(Long itemTypeId);

    /**
     * 添加条目
     */
    void addItem(DmItem dmItem);
}
