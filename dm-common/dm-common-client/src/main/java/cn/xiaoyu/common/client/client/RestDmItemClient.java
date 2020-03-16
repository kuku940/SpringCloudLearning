package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmItemClientFallBack;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.common.module.pojo.DmItem;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmItemClientFallBack.class)
public interface RestDmItemClient {
    @PostMapping(value = "/getDmItemById")
    public DmItem getDmItemById(@RequestParam("id") Long id) throws BizException;

    @PostMapping(value = "/getDmItemListByMap")
    public List<DmItem> getDmItemListByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/getDmItemCountByMap")
    public Integer getDmItemCountByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/qdtxAddDmItem")
    public Integer qdtxAddDmItem(@RequestBody DmItem dmItem) throws BizException;

    @PostMapping(value = "/qdtxModifyDmItem")
    public Integer qdtxModifyDmItem(@RequestBody DmItem dmItem) throws BizException;
}

