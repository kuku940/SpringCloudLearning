package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmItemTypeClientFallBack;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.common.module.pojo.DmItemType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmItemTypeClientFallBack.class)
public interface RestDmItemTypeClient {
    @PostMapping(value = "/getDmItemTypeById")
    public DmItemType getDmItemTypeById(@RequestParam("id") Long id) throws BizException;

    @PostMapping(value = "/getDmItemTypeListByMap")
    public List<DmItemType> getDmItemTypeListByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/getDmItemTypeCountByMap")
    public Integer getDmItemTypeCountByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/qdtxAddDmItemType")
    public Integer qdtxAddDmItemType(@RequestBody DmItemType dmItemType) throws BizException;

    @PostMapping(value = "/qdtxModifyDmItemType")
    public Integer qdtxModifyDmItemType(@RequestBody DmItemType dmItemType) throws BizException;
}

