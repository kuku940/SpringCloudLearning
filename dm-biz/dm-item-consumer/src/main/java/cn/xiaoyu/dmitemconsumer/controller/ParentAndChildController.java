package cn.xiaoyu.dmitemconsumer.controller;

import cn.xiaoyu.common.common.Dto;
import cn.xiaoyu.common.utils.Constants;
import cn.xiaoyu.common.utils.EmptyUtils;
import cn.xiaoyu.common.vo.MonthVo;
import cn.xiaoyu.common.vo.ParentAndChildVo;
import cn.xiaoyu.common.vo.SlideShowVo;
import cn.xiaoyu.dmitemconsumer.service.ParentAndChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 亲子首页Controller
 */
@RestController
@RequestMapping(value = "/api/p")
public class ParentAndChildController {
    @Autowired
    private ParentAndChildService parentAndChildService;

    /**
     * 根据分类查询轮播图
     *
     * @param param - itemTypeId 商品分类主键
     */
    @PostMapping(value = "/querySlideShowPic")
    public Dto<List<SlideShowVo>> querySlideShowPic(@RequestBody Map<String, Object> param, HttpServletResponse response) {
        Integer itemTypeId = Integer.parseInt(param.get("itemTypeId").toString());
        return parentAndChildService.querySlideShowPic((long) itemTypeId);
    }


    /**
     * 亲子首页精彩聚焦接口
     *
     * @param param-itemTypeId 商品分类主键
     * @param param-limit      请求数目
     */
    @PostMapping(value = "/queryItemNice")
    @ResponseBody
    public Dto<List<ParentAndChildVo>> queryItemNice(@RequestBody Map<String, Object> param) {
        return parentAndChildService.queryItem("itemType1Id", param.get("itemTypeId"), Integer.parseInt(param.get("limit").toString()), 0, Constants.Image.ImageType.POSTER);
    }

    /**
     * 亲子首页猜你喜欢接口
     *
     * @param param-itemTypeId 商品分类主键
     * @param param-limit      请求数目
     */
    @PostMapping(value = "/queryItemLike")
    @ResponseBody
    public Dto<List<ParentAndChildVo>> queryItemLike(@RequestBody Map<String, Object> param) {
        return parentAndChildService.queryItem("itemTypeId", param.get("itemTypeId"), Integer.parseInt(EmptyUtils.isNotEmpty(param.get("limit")) ? param.get("limit").toString() : Constants.DEFAULT_PAGE_SIZE.toString()), 0, Constants.Image.ImageType.NORMAL);
    }


    /**
     * 亲子首页 根据年龄段查询节目
     *
     * @param param-ageGroup 年龄段（0:全年龄段,1:0-3岁,2:3-6岁,3:6-12岁）
     * @param param-limit    请求数目
     */
    @PostMapping(value = "/queryItemByAge")
    @ResponseBody
    public Dto<List<ParentAndChildVo>> queryItemByAge(@RequestBody Map<String, Object> param) {
        return parentAndChildService.queryItem("ageGroup", param.get("ageGroup"), Integer.parseInt(param.get("limit").toString()), 0, Constants.Image.ImageType.CAROUSEL);
    }


    /**
     * 亲子首页 根据热门城市查询热门排行
     *
     * @param param-areaId 区域Id
     * @param param-limit  请求数目
     */
    @PostMapping(value = "/queryItemHot")
    @ResponseBody
    public Dto<List<ParentAndChildVo>> queryItemHot(@RequestBody Map<String, Object> param) {
        Integer areaId = Integer.parseInt(param.get("areaId").toString());
        return parentAndChildService.queryItemHot((long) areaId, (Integer) param.get("limit"));
    }


    /**
     * 亲子首页 根据月份查询演出
     *
     * @param param-month 月份(1,2,3,4.....)
     * @param param-year  年份(2018)
     */
    @PostMapping(value = "/queryItemByMonth")
    @ResponseBody
    public Dto<List<MonthVo>> queryItemByMonth(@RequestBody Map<String, Object> param) {
        Integer month = Integer.parseInt(param.get("month").toString());
        Integer year = Integer.parseInt(param.get("year").toString());
        Long itemTypeId = Long.parseLong(param.get("itemTypeId").toString());
        return parentAndChildService.queryItemByMonth(month, year, itemTypeId);
    }

    /**
     * 亲子首页 广告接口 图片为背景透明
     *
     * @param param-itemTypeId 商品分类主键
     * @param param-limit      请求数目
     */
    @PostMapping(value = "/queryAdvertising")
    @ResponseBody
    public Dto<List<ParentAndChildVo>> queryAdvertising(@RequestBody Map<String, Object> param) {
        Long itemTypeId = Long.parseLong(param.get("itemTypeId").toString());
        Integer limit = Integer.parseInt(param.get("limit").toString());
        return parentAndChildService.queryItem("itemType1Id", itemTypeId, limit, 0, Constants.Image.ImageType.NORMAL);
    }
}
