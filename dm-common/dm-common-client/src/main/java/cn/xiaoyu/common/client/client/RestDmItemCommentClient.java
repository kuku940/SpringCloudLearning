package cn.xiaoyu.common.client.client;

import cn.xiaoyu.common.client.config.DmConfiguration;
import cn.xiaoyu.common.client.fallback.DmItemCommentClientFallBack;
import cn.xiaoyu.common.module.pojo.DmItemComment;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dm-user-provider", configuration = DmConfiguration.class, fallback = DmItemCommentClientFallBack.class)
public interface RestDmItemCommentClient {
    @PostMapping(value = "/getDmItemCommentById")
    public DmItemComment getDmItemCommentById(@RequestParam("id") Long id);

    @PostMapping(value = "/getDmItemCommentListByMap")
    public List<DmItemComment> getDmItemCommentListByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/getDmItemCommentCountByMap")
    public Integer getDmItemCommentCountByMap(@RequestParam Map<String, Object> param);

    @PostMapping(value = "/qdtxAddDmItemComment")
    public Integer qdtxAddDmItemComment(@RequestBody DmItemComment dmItemComment);

    @PostMapping(value = "/qdtxModifyDmItemComment")
    public Integer qdtxModifyDmItemComment(@RequestBody DmItemComment dmItemComment);
}

