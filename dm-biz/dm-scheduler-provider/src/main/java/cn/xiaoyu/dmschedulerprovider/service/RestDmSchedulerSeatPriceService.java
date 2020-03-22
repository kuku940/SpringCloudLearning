package cn.xiaoyu.dmschedulerprovider.service;

import cn.xiaoyu.common.dao.mapper.DmSchedulerSeatPriceMapper;
import cn.xiaoyu.common.module.pojo.DmSchedulerSeatPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(value = "/getDmSchedulerSeatPriceById")
    public DmSchedulerSeatPrice getDmSchedulerSeatPriceById(@RequestParam("id") Long id) {
        return dmSchedulerSeatPriceMapper.getDmSchedulerSeatPriceById(id);
    }

    @PostMapping(value = "/getDmSchedulerSeatPriceListByMap")
    public List<DmSchedulerSeatPrice> getDmSchedulerSeatPriceListByMap(@RequestParam Map<String, Object> param) {
        return dmSchedulerSeatPriceMapper.getDmSchedulerSeatPriceListByMap(param);
    }

    @PostMapping(value = "/getDmSchedulerSeatPriceCountByMap")
    public Integer getDmSchedulerSeatPriceCountByMap(@RequestParam Map<String, Object> param) {
        return dmSchedulerSeatPriceMapper.getDmSchedulerSeatPriceCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmSchedulerSeatPrice")
    public Integer qdtxAddDmSchedulerSeatPrice(@RequestBody DmSchedulerSeatPrice dmSchedulerSeatPrice) {
        dmSchedulerSeatPrice.setCreatedTime(new Date());
        return dmSchedulerSeatPriceMapper.insertDmSchedulerSeatPrice(dmSchedulerSeatPrice);
    }

    @PostMapping(value = "/qdtxModifyDmSchedulerSeatPrice")
    public Integer qdtxModifyDmSchedulerSeatPrice(@RequestBody DmSchedulerSeatPrice dmSchedulerSeatPrice) {
        dmSchedulerSeatPrice.setUpdatedTime(new Date());
        return dmSchedulerSeatPriceMapper.updateDmSchedulerSeatPrice(dmSchedulerSeatPrice);
    }

    @PostMapping(value = "/getDmSchedulerSeatPriceBySchedulerIdAndArea")
    public DmSchedulerSeatPrice getDmSchedulerSeatPriceBySchedulerIdAndArea(@RequestParam("areaLevel") Integer areaLevel,
                                                                            @RequestParam("scheduleId") Long scheduleId) {
        return dmSchedulerSeatPriceMapper.getDmSchedulerSeatPriceBySchedulerIdAndArea(areaLevel, scheduleId);
    }

}
