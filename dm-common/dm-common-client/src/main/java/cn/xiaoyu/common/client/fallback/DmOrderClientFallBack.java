package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmOrderClient;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.common.module.pojo.DmOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmOrderClientFallBack implements RestDmOrderClient {
    @Override
    public DmOrder getDmOrderById(Long id) throws BizException {
        return null;
    }

    @Override
    public List<DmOrder> getDmOrderListByMap(Map<String, Object> param) throws BizException {
        return null;
    }

    @Override
    public Integer getDmOrderCountByMap(Map<String, Object> param) throws BizException {
        return null;
    }

    @Override
    public Integer qdtxAddDmOrder(DmOrder dmOrder) throws BizException {
        return null;
    }

    @Override
    public Integer qdtxModifyDmOrder(DmOrder dmOrder) throws BizException {
        return null;
    }
}
