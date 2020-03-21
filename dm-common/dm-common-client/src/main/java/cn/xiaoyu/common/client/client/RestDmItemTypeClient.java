package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmItemTypeClientFallBack;
import cn.xiaoyu.common.module.pojo.DmItemType;
import cn.xiaoyu.common.vo.DmItemTypeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-item-provider", configuration = DmConfiguration.class, fallback = DmItemTypeClientFallBack.class)
public interface RestDmItemTypeClient {
    @PostMapping(value = "/getDmItemTypeById")
    DmItemType getDmItemTypeById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmItemTypeListByMap")
    List<DmItemType> getDmItemTypeListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmItemTypeCountByMap")
    Integer getDmItemTypeCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmItemType")
    Integer qdtxAddDmItemType(@RequestBody DmItemType dmItemType);

    @PostMapping(value = "/qdtxModifyDmItemType")
    Integer qdtxModifyDmItemType(@RequestBody DmItemType dmItemType);

    @PostMapping(value = "/selectTestChildren")
    List<DmItemTypeVo> selectTestChildren();
}

