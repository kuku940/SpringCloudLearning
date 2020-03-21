package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmItemClientFallBack;
import cn.xiaoyu.common.common.Page;
import cn.xiaoyu.common.module.pojo.DmItem;
import cn.xiaoyu.common.vo.DmFloorItems;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmItemClientFallBack.class)
public interface RestDmItemClient {
    @PostMapping(value = "/getDmItemById")
    DmItem getDmItemById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmItemListByMap")
    List<DmItem> getDmItemListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getHotDmItemList")
    List<DmItem> getHotDmItemList(@RequestBody Map<String, Object> param);

    @PostMapping(value = "/getDmItemCountByMap")
    Integer getDmItemCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmItem")
    Integer qdtxAddDmItem(@RequestBody DmItem dmItem);

    @PostMapping(value = "/qdtxModifyDmItem")
    Integer qdtxModifyDmItem(@RequestBody DmItem dmItem);

    @PostMapping(value = "/queryItemByFloor")
    List<DmFloorItems> queryItemByFloor();

    @PostMapping(value = "/queryItemByMonth")
    List<DmItem> queryItemByMonth(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmItemListByMapForEs")
    List<DmItem> getDmItemListByMapForEs(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/queryDmItemPage")
    Page<DmItem> queryDmItemPage(@RequestParam Map<String, Object> param);
}

