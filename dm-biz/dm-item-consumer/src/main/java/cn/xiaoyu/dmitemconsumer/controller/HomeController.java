package cn.xiaoyu.dmitemconsumer.controller;

import cn.xiaoyu.common.common.Dto;
import cn.xiaoyu.common.common.DtoUtil;
import cn.xiaoyu.common.module.pojo.DmItemType;
import cn.xiaoyu.common.vo.DmFloorItems;
import cn.xiaoyu.common.vo.DmItemTypeVo;
import cn.xiaoyu.common.vo.HotItemVo;
import cn.xiaoyu.dmitemconsumer.service.HomeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 主页Controller
 */
@RestController
@RequestMapping("/api/p/index")
public class HomeController {

    @Resource
    private HomeService homeService;

    /**
     * 查询所有节目类型
     */
    @PostMapping(value = "/queryAllType")
    public Dto queryAllType() {
        List<DmItemTypeVo> dmItemTypeVos = homeService.queryAllItemType();
        return DtoUtil.returnDataSuccess(dmItemTypeVos);
    }

    /**
     * 查询横向导航条
     */
    @PostMapping(value = "/queryTransverse")
    public Dto queryTransverse() {
        List<DmItemType> dmItemTypeList = homeService.queryTransverse();
        return DtoUtil.returnDataSuccess(dmItemTypeList);
    }

    /**
     * 查询首页轮播图
     */
    @PostMapping(value = "/queryBanner")
    public Dto queryBanner() {
        List<HotItemVo> hotItemVoList = homeService.queryBanner();
        return DtoUtil.returnDataSuccess(hotItemVoList);
    }

    /**
     * 查询今日推荐
     */
    @PostMapping(value = "/queryTodayRecommend")
    public Dto queryTodayRecommend() {
        List<HotItemVo> hotItemVoList = homeService.queryTodayRecommend();
        return DtoUtil.returnDataSuccess(hotItemVoList);
    }

    /**
     * 查询即将开售接口
     */
    @PostMapping(value = "/queryToSaleItem")
    public Dto queryToSaleItem() {
        List<HotItemVo> hotItemVoList = homeService.queryToSaleItem();
        return DtoUtil.returnDataSuccess(hotItemVoList);
    }

    /**
     * 查询不同楼层的数据
     */
    @PostMapping(value = "/queryFloorItems")
    public Dto queryFloorItems() {
        List<DmFloorItems> dmFloorItems = homeService.queryFloorItems();
        return DtoUtil.returnDataSuccess(dmFloorItems);
    }

    /**
     * 查询热门节目
     */
    @PostMapping(value = "/queryHotItems")
    public Dto queryHotItems(@RequestBody Map<String, Long> params) {
        Long itemTypeId = params.get("itemTypeId");
        List<HotItemVo> hotItemVoList = homeService.queryHotItems(itemTypeId);
        return DtoUtil.returnDataSuccess(hotItemVoList);
    }
}
