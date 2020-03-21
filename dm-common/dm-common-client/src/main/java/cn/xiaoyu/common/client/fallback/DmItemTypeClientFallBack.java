package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmItemTypeClient;
import cn.xiaoyu.common.module.pojo.DmItemType;
import cn.xiaoyu.common.vo.DmItemTypeVo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmItemTypeClientFallBack implements RestDmItemTypeClient {
    @Override
    public DmItemType getDmItemTypeById(Long id) {
        return null;
    }

    @Override
    public List<DmItemType> getDmItemTypeListByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer getDmItemTypeCountByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer qdtxAddDmItemType(DmItemType dmItemType) {
        return null;
    }

    @Override
    public Integer qdtxModifyDmItemType(DmItemType dmItemType) {
        return null;
    }

    @Override
    public List<DmItemTypeVo> selectTestChildren() {
        return null;
    }
}
