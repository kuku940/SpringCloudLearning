package cn.xiaoyu.dmbaseprovider.service;

import cn.xiaoyu.common.dao.mapper.DmSchedulerSeatPriceMapper;
import cn.xiaoyu.common.module.pojo.DmSchedulerSeatPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmSchedulerSeatPriceService {
    @Autowired
    private DmSchedulerSeatPriceMapper dmSchedulerSeatPriceMapper;

    @GetMapping(value = "/getDmSchedulerSeatPriceById")
    public DmSchedulerSeatPrice getDmSchedulerSeatPriceById(@RequestParam("id") Long id) {
        return dmSchedulerSeatPriceMapper.getDmSchedulerSeatPriceById(id);
    }

    @GetMapping(value = "/getDmSchedulerSeatPriceListByMap")
    public List<DmSchedulerSeatPrice> getDmSchedulerSeatPriceListByMap(@RequestParam Map<String, Object> param) {
        return dmSchedulerSeatPriceMapper.getDmSchedulerSeatPriceListByMap(param);
    }

    @GetMapping(value = "/getDmSchedulerSeatPriceCountByMap")
    public Integer getDmSchedulerSeatPriceCountByMap(@RequestParam Map<String, Object> param) {
        return dmSchedulerSeatPriceMapper.getDmSchedulerSeatPriceCountByMap(param);
    }

    @GetMapping(value = "/qdtxAddDmSchedulerSeatPrice")
    public Integer qdtxAddDmSchedulerSeatPrice(@RequestBody DmSchedulerSeatPrice dmSchedulerSeatPrice) {
        dmSchedulerSeatPrice.setCreatedTime(new Date());
        return dmSchedulerSeatPriceMapper.insertDmSchedulerSeatPrice(dmSchedulerSeatPrice);
    }

    @GetMapping(value = "/qdtxModifyDmSchedulerSeatPrice")
    public Integer qdtxModifyDmSchedulerSeatPrice(@RequestBody DmSchedulerSeatPrice dmSchedulerSeatPrice) {
        dmSchedulerSeatPrice.setUpdatedTime(new Date());
        return dmSchedulerSeatPriceMapper.updateDmSchedulerSeatPrice(dmSchedulerSeatPrice);
    }
}
