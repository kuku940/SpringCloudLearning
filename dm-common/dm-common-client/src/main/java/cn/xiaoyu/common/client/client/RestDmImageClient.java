package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmImageClientFallBack;
import cn.xiaoyu.common.module.pojo.DmImage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-base-provider", configuration = DmConfiguration.class, fallback = DmImageClientFallBack.class)
public interface RestDmImageClient {

    @PostMapping(value = "/getDmImageById")
    DmImage getDmImageById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmImageListByMap")
    List<DmImage> getDmImageListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmImageCountByMap")
    Integer getDmImageCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmImage")
    Integer qdtxAddDmImage(@RequestBody DmImage dmImage);

    @PostMapping(value = "/qdtxModifyDmImage")
    Integer qdtxModifyDmImage(@RequestBody DmImage dmImage);

    @PostMapping(value = "/queryDmImageList")
    List<DmImage> queryDmImageList(@RequestParam("targetId") Long targetId,
                                   @RequestParam(value = "type", required = false) Integer type,
                                   @RequestParam(value = "category", required = false) Integer category);
}
