package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmCinemaClientFallBack;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.common.module.pojo.DmCinema;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmCinemaClientFallBack.class)
public interface RestDmCinemaClient {
    @PostMapping(value = "/getDmCinemaById")
    public DmCinema getDmCinemaById(@RequestParam("id") Long id) throws BizException;

    @PostMapping(value = "/getDmCinemaListByMap")
    public List<DmCinema> getDmCinemaListByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/getDmCinemaCountByMap")
    public Integer getDmCinemaCountByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/qdtxAddDmCinema")
    public Integer qdtxAddDmCinema(@RequestBody DmCinema dmCinema) throws BizException;

    @PostMapping(value = "/qdtxModifyDmCinema")
    public Integer qdtxModifyDmCinema(@RequestBody DmCinema dmCinema) throws BizException;
}

