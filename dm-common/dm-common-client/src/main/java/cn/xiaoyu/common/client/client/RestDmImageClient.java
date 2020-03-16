package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmImageClientFallBack;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.common.module.pojo.DmImage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-item-provider", configuration = DmConfiguration.class, fallback = DmImageClientFallBack.class)
public interface RestDmImageClient {

    @PostMapping(value = "/getDmImageById")
    public DmImage getDmImageById(@RequestParam("id") Long id) throws BizException;

    @PostMapping(value = "/getDmImageListByMap")
    public List<DmImage> getDmImageListByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/getDmImageCountByMap")
    public Integer getDmImageCountByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/qdtxAddDmImage")
    public Integer qdtxAddDmImage(@RequestBody DmImage dmImage) throws BizException;

    @PostMapping(value = "/qdtxModifyDmImage")
    public Integer qdtxModifyDmImage(@RequestBody DmImage dmImage) throws BizException;
}
