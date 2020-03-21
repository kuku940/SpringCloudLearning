package cn.xiaoyu.dmitemprovider.service;

import cn.xiaoyu.common.dao.mapper.DmCinemaSeatMapper;
import cn.xiaoyu.common.module.pojo.DmCinemaSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmCinemaSeatService {
    @Autowired
    private DmCinemaSeatMapper dmCinemaSeatMapper;

    @PostMapping(value = "/getDmCinemaSeatById")
    public DmCinemaSeat getDmCinemaSeatById(@RequestParam("id") Long id) {
        return dmCinemaSeatMapper.getDmCinemaSeatById(id);
    }

    @PostMapping(value = "/getDmCinemaSeatListByMap")
    public List<DmCinemaSeat> getDmCinemaSeatListByMap(@RequestParam Map<String, Object> param) {
        return dmCinemaSeatMapper.getDmCinemaSeatListByMap(param);
    }

    @PostMapping(value = "/getDmCinemaSeatCountByMap")
    public Integer getDmCinemaSeatCountByMap(@RequestParam Map<String, Object> param) {
        return dmCinemaSeatMapper.getDmCinemaSeatCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmCinemaSeat")
    public Integer qdtxAddDmCinemaSeat(@RequestBody DmCinemaSeat dmCinemaSeat) {
        dmCinemaSeat.setCreatedTime(new Date());
        return dmCinemaSeatMapper.insertDmCinemaSeat(dmCinemaSeat);
    }

    @PostMapping(value = "/qdtxModifyDmCinemaSeat")
    public Integer qdtxModifyDmCinemaSeat(@RequestBody DmCinemaSeat dmCinemaSeat) {
        dmCinemaSeat.setUpdatedTime(new Date());
        return dmCinemaSeatMapper.updateDmCinemaSeat(dmCinemaSeat);
    }
}
