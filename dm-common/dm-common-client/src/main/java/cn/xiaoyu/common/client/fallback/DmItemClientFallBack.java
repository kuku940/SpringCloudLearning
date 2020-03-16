package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmItemClient;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.common.module.pojo.DmItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmItemClientFallBack implements RestDmItemClient {
    @Override
    public DmItem getDmItemById(Long id) throws BizException {
        return null;
    }

    @Override
    public List<DmItem> getDmItemListByMap(Map<String, Object> param) throws BizException {
        return null;
    }

    @Override
    public Integer getDmItemCountByMap(Map<String, Object> param) throws BizException {
        return null;
    }

    @Override
    public Integer qdtxAddDmItem(DmItem dmItem) throws BizException {
        return null;
    }

    @Override
    public Integer qdtxModifyDmItem(DmItem dmItem) throws BizException {
        return null;
    }
}
