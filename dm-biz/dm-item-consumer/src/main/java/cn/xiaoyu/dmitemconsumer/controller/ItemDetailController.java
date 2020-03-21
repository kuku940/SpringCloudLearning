package cn.xiaoyu.dmitemconsumer.controller;

import cn.xiaoyu.common.common.Dto;
import cn.xiaoyu.common.utils.Constants;
import cn.xiaoyu.common.vo.*;
import cn.xiaoyu.dmitemconsumer.service.ItemDetailService;
import cn.xiaoyu.dmitemconsumer.service.ParentAndChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 商品详情页Controller
 */
@RestController
@RequestMapping(value = "/api")
public class ItemDetailController {

    @Autowired
    private ItemDetailService itemDetailService;

    @Autowired
    private ParentAndChildService parentAndChildService;

    /**
     * 根据商品id返回商品详情页
     *
     * @param param-id 商品Id
     */
    @PostMapping(value = "/p/queryItemDetail")
    @ResponseBody
    public Dto<ItemDetailVo> queryItemDetail(@RequestBody Map<String, Object> param) {
        Integer id = Integer.parseInt(param.get("id").toString());
        return itemDetailService.queryItemDetail((long) id);
    }


    /**
     * 根据商品ID查询商品排期
     *
     * @param param-id 商品Id
     */
    @PostMapping(value = "/p/queryItemScheduler")
    @ResponseBody
    public Dto<List<ItemSchedulerVo>> queryItemScheduler(@RequestBody Map<String, Object> param) {
        Integer id = Integer.parseInt(param.get("itemId").toString());
        return itemDetailService.queryItemScheduler((long) id);
    }

    /**
     * 根据商品排期查询商品价格
     *
     * @param param-scheduleId 商品排期ID
     */
    @PostMapping(value = "/p/queryItemPrice")
    @ResponseBody
    public Dto<List<ItemPriceVo>> queryItemPrice(@RequestBody Map<String, Object> param) {
        Integer id = Integer.parseInt(param.get("scheduleId").toString());
        return itemDetailService.queryItemPrice((long) id);
    }


    /**
     * 根据商品Id查询剧评
     *
     * @param param-id 商品ID
     */
    @PostMapping(value = "/p/queryItemComment")
    @ResponseBody
    public Dto<List<ItemCommentVo>> queryItemComment(@RequestBody Map<String, Object> param) {
        Integer id = Integer.parseInt(param.get("id").toString());
        return itemDetailService.queryItemComment((long) id);
    }

    /**
     * 推荐接口
     *
     * @param param-itemTypeId 商品分类主键
     * @param param-limit      请求数目
     */
    @PostMapping(value = "/p/queryItemRecommend")
    @ResponseBody
    public Dto<List<ParentAndChildVo>> queryItemRecommend(@RequestBody Map<String, Object> param) {
        return parentAndChildService.queryItem("itemType2Id", param.get("itemTypeId"), (Integer) param.get("limit"), 1, Constants.Image.ImageType.CAROUSEL);
    }

    /**
     * 添加剧评
     */
    @PostMapping(value = "/v/commitItemComment")
    @ResponseBody
    public Dto commitItemComment(@RequestBody Map<String, Object> param) {
        Integer itemId = Integer.parseInt(param.get("itemId").toString());
        Integer userId = Integer.parseInt(param.get("userId").toString());
        return itemDetailService.commitItemComment((long) itemId, (long) userId, (Integer) param.get("score"), (String) param.get("comment"));
    }
}
