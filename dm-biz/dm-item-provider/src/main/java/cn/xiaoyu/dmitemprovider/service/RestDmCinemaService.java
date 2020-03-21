package cn.xiaoyu.dmitemprovider.service;

import cn.xiaoyu.common.dao.mapper.DmCinemaMapper;
import cn.xiaoyu.common.module.pojo.DmCinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmCinemaService {
    @Autowired
    private DmCinemaMapper dmCinemaMapper;

    @PostMapping(value = "/getDmCinemaById")
    public DmCinema getDmCinemaById(@RequestParam("id") Long id) {
        return dmCinemaMapper.getDmCinemaById(id);
    }

    @PostMapping(value = "/getDmCinemaListByMap")
    public List<DmCinema> getDmCinemaListByMap(@RequestParam Map<String, Object> param) {
        return dmCinemaMapper.getDmCinemaListByMap(param);
    }

    @PostMapping(value = "/getDmCinemaCountByMap")
    public Integer getDmCinemaCountByMap(@RequestParam Map<String, Object> param) {
        return dmCinemaMapper.getDmCinemaCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmCinema")
    public Integer qdtxAddDmCinema(@RequestBody DmCinema dmCinema) {
        dmCinema.setCreatedTime(new Date());
        return dmCinemaMapper.insertDmCinema(dmCinema);
    }

    @PostMapping(value = "/qdtxModifyDmCinema")
    public Integer qdtxModifyDmCinema(@RequestBody DmCinema dmCinema) {
        dmCinema.setUpdatedTime(new Date());
        return dmCinemaMapper.updateDmCinema(dmCinema);
    }
}
