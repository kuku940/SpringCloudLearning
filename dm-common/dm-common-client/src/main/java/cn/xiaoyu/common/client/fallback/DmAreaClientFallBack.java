package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmAreaClient;
import cn.xiaoyu.common.module.pojo.DmArea;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmAreaClientFallBack implements RestDmAreaClient {
    @Override
    public DmArea getDmAreaById(Long id) {
        return null;
    }

    @Override
    public List<DmArea> getDmAreaListByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer getDmAreaCountByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer qdtxAddDmArea(DmArea dmArea) {
        return null;
    }

    @Override
    public Integer qdtxModifyDmArea(DmArea dmArea) {
        return null;
    }
}
