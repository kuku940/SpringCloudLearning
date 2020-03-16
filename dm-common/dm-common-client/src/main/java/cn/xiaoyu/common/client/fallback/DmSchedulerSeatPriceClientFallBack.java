package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmSchedulerSeatPriceClient;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.common.module.pojo.DmSchedulerSeatPrice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmSchedulerSeatPriceClientFallBack implements RestDmSchedulerSeatPriceClient {
    @Override
    public DmSchedulerSeatPrice getDmSchedulerSeatPriceById(Long id) throws BizException {
        return null;
    }

    @Override
    public List<DmSchedulerSeatPrice> getDmSchedulerSeatPriceListByMap(Map<String, Object> param) throws BizException {
        return null;
    }

    @Override
    public Integer getDmSchedulerSeatPriceCountByMap(Map<String, Object> param) throws BizException {
        return null;
    }

    @Override
    public Integer qdtxAddDmSchedulerSeatPrice(DmSchedulerSeatPrice dmSchedulerSeatPrice) throws BizException {
        return null;
    }

    @Override
    public Integer qdtxModifyDmSchedulerSeatPrice(DmSchedulerSeatPrice dmSchedulerSeatPrice) throws BizException {
        return null;
    }
}
