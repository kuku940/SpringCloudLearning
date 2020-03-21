package cn.xiaoyu.dmbaseprovider.service;

import cn.xiaoyu.common.dao.mapper.DmSchedulerSeatMapper;
import cn.xiaoyu.common.module.pojo.DmSchedulerSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmSchedulerSeatService {
    @Autowired
    private DmSchedulerSeatMapper dmSchedulerSeatMapper;

    @GetMapping(value = "/getDmSchedulerSeatById")
    public DmSchedulerSeat getDmSchedulerSeatById(@RequestParam("id") Long id) {
        return dmSchedulerSeatMapper.getDmSchedulerSeatById(id);
    }

    @GetMapping(value = "/getDmSchedulerSeatListByMap")
    public List<DmSchedulerSeat> getDmSchedulerSeatListByMap(@RequestParam Map<String, Object> param) {
        return dmSchedulerSeatMapper.getDmSchedulerSeatListByMap(param);
    }

    @GetMapping(value = "/getDmSchedulerSeatCountByMap")
    public Integer getDmSchedulerSeatCountByMap(@RequestParam Map<String, Object> param) {
        return dmSchedulerSeatMapper.getDmSchedulerSeatCountByMap(param);
    }

    @GetMapping(value = "/qdtxAddDmSchedulerSeat")
    public Integer qdtxAddDmSchedulerSeat(@RequestBody DmSchedulerSeat dmSchedulerSeat) {
        dmSchedulerSeat.setCreatedTime(new Date());
        return dmSchedulerSeatMapper.insertDmSchedulerSeat(dmSchedulerSeat);
    }

    @GetMapping(value = "/qdtxModifyDmSchedulerSeat")
    public Integer qdtxModifyDmSchedulerSeat(@RequestBody DmSchedulerSeat dmSchedulerSeat) {
        dmSchedulerSeat.setUpdatedTime(new Date());
        return dmSchedulerSeatMapper.updateDmSchedulerSeat(dmSchedulerSeat);
    }
}
