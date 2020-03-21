package cn.xiaoyu.dmbaseprovider.service;

import cn.xiaoyu.common.dao.mapper.DmAreaMapper;
import cn.xiaoyu.common.module.pojo.DmArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmAreaService {
    @Autowired
    private DmAreaMapper dmAreaMapper;

    @GetMapping(value = "/getDmAreaById")
    public DmArea getDmAreaById(@RequestParam("id") Long id) {
        return dmAreaMapper.getDmAreaById(id);
    }

    @GetMapping(value = "/getDmAreaListByMap")
    public List<DmArea> getDmAreaListByMap(@RequestParam Map<String, Object> param) {
        return dmAreaMapper.getDmAreaListByMap(param);
    }

    @GetMapping(value = "/getDmAreaCountByMap")
    public Integer getDmAreaCountByMap(@RequestParam Map<String, Object> param) {
        return dmAreaMapper.getDmAreaCountByMap(param);
    }

    @GetMapping(value = "/qdtxAddDmArea")
    public Integer qdtxAddDmArea(@RequestBody DmArea dmArea) {
        dmArea.setCreatedTime(new Date());
        return dmAreaMapper.insertDmArea(dmArea);
    }

    @GetMapping(value = "/qdtxModifyDmArea")
    public Integer qdtxModifyDmArea(@RequestBody DmArea dmArea) {
        dmArea.setUpdatedTime(new Date());
        return dmAreaMapper.updateDmArea(dmArea);
    }
}
