package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmItemClient;
import cn.xiaoyu.common.common.Page;
import cn.xiaoyu.common.module.pojo.DmItem;
import cn.xiaoyu.common.vo.DmFloorItems;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmItemClientFallBack implements RestDmItemClient {

    @Override
    public DmItem getDmItemById(Long id) {
        return null;
    }

    @Override
    public List<DmItem> getDmItemListByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public List<DmItem> getHotDmItemList(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer getDmItemCountByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer qdtxAddDmItem(DmItem dmItem) {
        return null;
    }

    @Override
    public Integer qdtxModifyDmItem(DmItem dmItem) {
        return null;
    }

    @Override
    public List<DmFloorItems> queryItemByFloor() {
        return null;
    }

    @Override
    public List<DmItem> queryItemByMonth(Map<String, Object> param) {
        return null;
    }

    @Override
    public List<DmItem> getDmItemListByMapForEs(Map<String, Object> param) {
        return null;
    }

    @Override
    public Page<DmItem> queryDmItemPage(Map<String, Object> param) {
        return null;
    }
}
