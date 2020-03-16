package cn.xiaoyu.common.client.client;


import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmCinemaSeatClientFallBack;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.common.module.pojo.DmCinemaSeat;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmCinemaSeatClientFallBack.class)
public interface RestDmCinemaSeatClient {
    @PostMapping(value = "/getDmCinemaSeatById")
    public DmCinemaSeat getDmCinemaSeatById(@RequestParam("id") Long id) throws BizException;

    @PostMapping(value = "/getDmCinemaSeatListByMap")
    public List<DmCinemaSeat> getDmCinemaSeatListByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/getDmCinemaSeatCountByMap")
    public Integer getDmCinemaSeatCountByMap(@RequestParam Map<String, Object> param) throws BizException;

    @PostMapping(value = "/qdtxAddDmCinemaSeat")
    public Integer qdtxAddDmCinemaSeat(@RequestBody DmCinemaSeat dmCinemaSeat) throws BizException;

    @PostMapping(value = "/qdtxModifyDmCinemaSeat")
    public Integer qdtxModifyDmCinemaSeat(@RequestBody DmCinemaSeat dmCinemaSeat) throws BizException;
}

