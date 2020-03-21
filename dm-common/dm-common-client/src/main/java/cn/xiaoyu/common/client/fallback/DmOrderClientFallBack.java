package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmOrderClient;
import cn.xiaoyu.common.module.pojo.DmOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmOrderClientFallBack implements RestDmOrderClient {

    @Override
    public DmOrder getDmOrderById(Long id) {
        return null;
    }

    @Override
    public List<DmOrder> getDmOrderListByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer getDmOrderCountByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer qdtxAddDmOrder(DmOrder dmOrder) {
        return null;
    }

    @Override
    public Integer qdtxModifyDmOrder(DmOrder dmOrder) {
        return null;
    }

    @Override
    public List<DmOrder> getDmOrderListByOrderNoOrDate(Map<String, Object> param) {
        return null;
    }

    @Override
    public DmOrder getDmOrderByOrderNo(String orderNo) {
        return null;
    }

    @Override
    public Integer deleteDmOrderById(Long id) {
        return null;
    }

    @Override
    public boolean flushCancelOrderType() {
        return false;
    }

    @Override
    public List<DmOrder> getDmOrderByOrderTypeAndTime() {
        return null;
    }

    @Override
    public boolean processed(String orderNo, Integer flag) {
        return false;
    }
}
