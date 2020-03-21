package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmImageClient;
import cn.xiaoyu.common.module.pojo.DmImage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmImageClientFallBack implements RestDmImageClient {
    @Override
    public DmImage getDmImageById(Long id) {
        return null;
    }

    @Override
    public List<DmImage> getDmImageListByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer getDmImageCountByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer qdtxAddDmImage(DmImage dmImage) {
        return null;
    }

    @Override
    public Integer qdtxModifyDmImage(DmImage dmImage) {
        return null;
    }

    @Override
    public List<DmImage> queryDmImageList(Long targetId, Integer type, Integer category) {
        return null;
    }
}
