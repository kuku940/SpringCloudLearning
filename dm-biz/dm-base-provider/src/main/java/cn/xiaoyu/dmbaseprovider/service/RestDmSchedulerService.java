package cn.xiaoyu.dmbaseprovider.service;

import cn.xiaoyu.common.dao.mapper.DmSchedulerMapper;
import cn.xiaoyu.common.module.pojo.DmScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmSchedulerService {
    @Autowired
    private DmSchedulerMapper dmSchedulerMapper;

    @PostMapping(value = "/getDmSchedulerById")
    public DmScheduler getDmSchedulerById(@RequestParam("id") Long id) {
        return dmSchedulerMapper.getDmSchedulerById(id);
    }

    @PostMapping(value = "/getDmSchedulerListByMap")
    public List<DmScheduler> getDmSchedulerListByMap(@RequestParam Map<String, Object> param) {
        return dmSchedulerMapper.getDmSchedulerListByMap(param);
    }

    @PostMapping(value = "/getDmSchedulerCountByMap")
    public Integer getDmSchedulerCountByMap(@RequestParam Map<String, Object> param) {
        return dmSchedulerMapper.getDmSchedulerCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmScheduler")
    public Integer qdtxAddDmScheduler(@RequestBody DmScheduler dmScheduler) {
        dmScheduler.setCreatedTime(new Date());
        return dmSchedulerMapper.insertDmScheduler(dmScheduler);
    }

    @PostMapping(value = "/qdtxModifyDmScheduler")
    public Integer qdtxModifyDmScheduler(@RequestBody DmScheduler dmScheduler) {
        dmScheduler.setUpdatedTime(new Date());
        return dmSchedulerMapper.updateDmScheduler(dmScheduler);
    }
}
