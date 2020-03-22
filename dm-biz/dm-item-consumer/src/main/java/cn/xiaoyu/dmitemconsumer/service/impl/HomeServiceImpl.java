package cn.xiaoyu.dmitemconsumer.service.impl;

import cn.xiaoyu.common.client.client.RestDmImageClient;
import cn.xiaoyu.common.client.client.RestDmItemClient;
import cn.xiaoyu.common.client.client.RestDmItemTypeClient;
import cn.xiaoyu.common.module.pojo.DmImage;
import cn.xiaoyu.common.module.pojo.DmItem;
import cn.xiaoyu.common.module.pojo.DmItemType;
import cn.xiaoyu.common.utils.Constants;
import cn.xiaoyu.common.utils.DateUtil;
import cn.xiaoyu.common.utils.EmptyUtils;
import cn.xiaoyu.common.utils.RedisUtils;
import cn.xiaoyu.common.vo.DmFloorItems;
import cn.xiaoyu.common.vo.DmItemTypeVo;
import cn.xiaoyu.common.vo.DmItemVo;
import cn.xiaoyu.common.vo.HotItemVo;
import cn.xiaoyu.dmitemconsumer.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static cn.xiaoyu.common.utils.Constants.BEGIN_POS;
import static cn.xiaoyu.common.utils.Constants.Image.ImageCategory.ITEM;
import static cn.xiaoyu.common.utils.Constants.Image.ImageType.CAROUSEL;
import static cn.xiaoyu.common.utils.Constants.Image.ImageType.NORMAL;
import static cn.xiaoyu.common.utils.Constants.PAGE_SIZE;

@Component
public class HomeServiceImpl implements HomeService {
    private static final Logger logger = LoggerFactory.getLogger(HomeServiceImpl.class);

    @Autowired
    private RestDmItemTypeClient restDmItemTypeClient;
    @Autowired
    private RestDmItemClient restDmItemClient;
    @Autowired
    private RestDmImageClient restDmImageClient;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 查询所有节目类型和热门节目
     */
    @Override
    public List<DmItemTypeVo> queryAllItemType() {
        List<DmItemTypeVo> dmItemTypeVos = restDmItemTypeClient.selectTestChildren();
        if (EmptyUtils.isNotEmpty(dmItemTypeVos)) {
            for (DmItemTypeVo dmItemTypeVo : dmItemTypeVos) {
                List<HotItemVo> hotItemVoList = dmItemTypeVo.getHotItems();
                if (EmptyUtils.isNotEmpty(hotItemVoList)) {
                    for (HotItemVo dmItem : hotItemVoList) {
                        //查询图片信息
                        String imgUrl = getImageUrl(restDmImageClient, dmItem.getId(), NORMAL, ITEM);
                        dmItem.setImgUrl(imgUrl);
                    }
                }
            }
        }
        return dmItemTypeVos;
    }

    /**
     * 查询图片信息
     */
    public String getImageUrl(RestDmImageClient restDmImageClient, Long id, Integer type, Integer category) {
        //查询图片信息
        List<DmImage> dmImageList = null;
        //从reidis中获取图片信息
        String key = Constants.IMAGE_TOKEN_PREFIX + id + "_" + type + "_" + category;
//        String imgUrl = (String) redisUtils.get(key);
//        //如果redis中没有,则到数据库中获取
//        if (EmptyUtils.isEmpty(imgUrl)) {
//            dmImageList = restDmImageClient.queryDmImageList(id, type, category);
//            imgUrl = dmImageList.get(0).getImgUrl();
//            //同步图片到redis
//            redisUtils.set(key, imgUrl);
//        }
//        return imgUrl;
        return key;
    }

    /**
     * 查询横向导航条
     */
    @Override
    public List<DmItemType> queryTransverse() {
        Map<String, Object> param = new HashMap<>();
        param.put("level", "1");
        return restDmItemTypeClient.getDmItemTypeListByMap(param);
    }

    /**
     * 查询导航条
     */
    @Override
    public List<HotItemVo> queryBanner() {
        Map<String, Object> param = new HashMap<>();
        param.put("isBanner", 1);
        param.put(BEGIN_POS, 0);
        param.put(PAGE_SIZE, 5);
        List<DmItem> dmItemList = restDmItemClient.getDmItemListByMap(param);
        List<HotItemVo> hotItemVoList = new ArrayList<>();
        if (EmptyUtils.isEmpty(dmItemList)) {
            return null;
        }

        for (DmItem dmItem : dmItemList) {
            HotItemVo hotItemVo = new HotItemVo();
            BeanUtils.copyProperties(dmItem, hotItemVo);
            String imgUrl = getImageUrl(restDmImageClient, dmItem.getId(), CAROUSEL, ITEM);
            hotItemVo.setImgUrl(imgUrl);
            hotItemVoList.add(hotItemVo);
        }

        return hotItemVoList;
    }

    /**
     * 查询今日推荐接口queryToSaleItem
     */
    public List<HotItemVo> queryToSaleItem() {
        //1.获取当前日期 输出 YYYY-MM-DD
        String now = DateUtil.format(new Date(), "yyyy-MM-dd  HH:mm:ss");
        String tomorrow = DateUtil.format(DateUtil.addDay(new Date(), 1), "yyyy-MM-dd  HH:mm:ss");
        //2.查询大于当前时间但小于24小时的节目
        Map<String, Object> param = new HashMap<>();
        param.put("minTime", now);
        param.put("maxTime", tomorrow);
        param.put(BEGIN_POS, 0);
        param.put(PAGE_SIZE, 6);
        List<DmItem> dmItemList = restDmItemClient.getDmItemListByMap(param);
        List<HotItemVo> hotItemVoList = new ArrayList<>();
        if (EmptyUtils.isEmpty(dmItemList)) {
            return null;
        }
        for (DmItem dmItem : dmItemList) {
            HotItemVo hotItemVo = new HotItemVo();
            BeanUtils.copyProperties(dmItem, hotItemVo);
            String imgUrl = getImageUrl(restDmImageClient, dmItem.getId(), NORMAL, ITEM);
            hotItemVo.setImgUrl(imgUrl);
            hotItemVoList.add(hotItemVo);
        }
        return hotItemVoList;
    }

    /**
     * 查询当日推荐节目
     */
    @Override
    public List<HotItemVo> queryTodayRecommend() {
        Map<String, Object> param = new HashMap<>();
        param.put("isRecommend", 1);
        param.put(BEGIN_POS, 0);
        param.put(PAGE_SIZE, 6);
        List<DmItem> dmItemList = restDmItemClient.getDmItemListByMap(param);
        List<HotItemVo> hotItemVoList = new ArrayList<>();
        if (EmptyUtils.isEmpty(dmItemList)) {
            return null;
        }
        for (DmItem dmItem : dmItemList) {
            HotItemVo hotItemVo = new HotItemVo();
            BeanUtils.copyProperties(dmItem, hotItemVo);
            String imgUrl = getImageUrl(restDmImageClient, dmItem.getId(), NORMAL, ITEM);
            hotItemVo.setImgUrl(imgUrl);
            hotItemVoList.add(hotItemVo);
        }
        return hotItemVoList;
    }

    /**
     * 查询不同楼层的数据
     */
    @Override
    public List<DmFloorItems> queryFloorItems() {
        List<DmFloorItems> dmFloorItemsList = restDmItemClient.queryItemByFloor();
        if (EmptyUtils.isEmpty(dmFloorItemsList)) {
            return new ArrayList<>();
        }
        for (DmFloorItems dmFloorItems : dmFloorItemsList) {
            for (DmItemVo item : dmFloorItems.getItems()) {
                String imgUrl = getImageUrl(restDmImageClient, item.getId(), NORMAL, ITEM);
                item.setImgUrl(imgUrl);
            }
        }
        return dmFloorItemsList;
    }

    /***
     * 查询热门节目
     */
    @Override
    public List<HotItemVo> queryHotItems(Long itemTypeId) {
        List<HotItemVo> hotItemVoList = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put("sortDesc", "commentCount");
        param.put("itemType1Id", itemTypeId);
        param.put(BEGIN_POS, 0);
        param.put(PAGE_SIZE, 10);
        List<DmItem> itemList = restDmItemClient.getDmItemListByMap(param);
        // 组装接口返回数据
        if (EmptyUtils.isEmpty(itemList)) {
            return new ArrayList<>();
        }
        for (DmItem dmItem : itemList) {
            HotItemVo hotItemVo = new HotItemVo();
            BeanUtils.copyProperties(dmItem, hotItemVo);
            // 组装图片信息
            String imgUrl = getImageUrl(restDmImageClient, dmItem.getId(), NORMAL, ITEM);
            hotItemVo.setImgUrl(imgUrl);
            hotItemVoList.add(hotItemVo);
        }
        return hotItemVoList;
    }

    public void addItem(DmItem dmItem) {
        try {
            restDmItemClient.qdtxAddDmItem(dmItem);
        } catch (Exception e) {
            logger.error("HomeServiceImpl.addItem Error", e);
        }
    }
}
