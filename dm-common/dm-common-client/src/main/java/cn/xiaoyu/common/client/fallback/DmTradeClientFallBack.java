package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmTradeClient;
import cn.xiaoyu.common.module.pojo.DmTrade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmTradeClientFallBack implements RestDmTradeClient {
    @Override
    public DmTrade getDmTradeById(Long id) {
        return null;
    }

    @Override
    public List<DmTrade> getDmTradeListByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer getDmTradeCountByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer qdtxAddDmTrade(DmTrade dmTrade) {
        return null;
    }

    @Override
    public Integer qdtxModifyDmTrade(DmTrade dmTrade) {
        return null;
    }
}
