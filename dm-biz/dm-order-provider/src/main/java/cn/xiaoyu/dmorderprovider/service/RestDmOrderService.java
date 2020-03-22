package cn.xiaoyu.dmorderprovider.service;

import cn.xiaoyu.common.dao.mapper.DmOrderMapper;
import cn.xiaoyu.common.module.pojo.DmOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmOrderService {
    @Autowired
    private DmOrderMapper dmOrderMapper;

    @PostMapping(value = "/getDmOrderById")
    public DmOrder getDmOrderById(@RequestParam("id") Long id) {
        return dmOrderMapper.getDmOrderById(id);
    }

    @PostMapping(value = "/getDmOrderListByMap")
    public List<DmOrder> getDmOrderListByMap(@RequestParam Map<String, Object> param) {
        return dmOrderMapper.getDmOrderListByMap(param);
    }

    @PostMapping(value = "/getDmOrderCountByMap")
    public Integer getDmOrderCountByMap(@RequestParam Map<String, Object> param) {
        return dmOrderMapper.getDmOrderCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmOrder")
    public Long qdtxAddDmOrder(@RequestBody DmOrder dmOrder) {
        dmOrder.setCreatedTime(new Date());
        dmOrderMapper.insertDmOrder(dmOrder);
        return dmOrder.getId();
    }

    @PostMapping(value = "/qdtxModifyDmOrder")
    public Long qdtxModifyDmOrder(@RequestBody DmOrder dmOrder) {
        dmOrder.setUpdatedTime(new Date());
        dmOrderMapper.updateDmOrder(dmOrder);
        return dmOrder.getId();
    }

    @PostMapping(value = "/deleteDmOrderById")
    public Integer deleteDmOrderById(@RequestParam("id") Long id) {
        return dmOrderMapper.deleteDmOrderById(id);
    }
}
