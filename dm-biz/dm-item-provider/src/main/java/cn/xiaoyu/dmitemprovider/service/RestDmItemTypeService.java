package cn.xiaoyu.dmitemprovider.service;

import cn.xiaoyu.common.dao.mapper.DmItemTypeMapper;
import cn.xiaoyu.common.module.pojo.DmItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmItemTypeService {

    @Autowired
    private DmItemTypeMapper dmItemTypeMapper;

    @PostMapping(value = "/getDmItemTypeById")
    public DmItemType getDmItemTypeById(@RequestParam("id") Long id) {
        return dmItemTypeMapper.getDmItemTypeById(id);
    }

    @PostMapping(value = "/getDmItemTypeListByMap")
    public List<DmItemType> getDmItemTypeListByMap(@RequestParam Map<String, Object> param) {
        return dmItemTypeMapper.getDmItemTypeListByMap(param);
    }

    @PostMapping(value = "/getDmItemTypeCountByMap")
    public Integer getDmItemTypeCountByMap(@RequestParam Map<String, Object> param) {
        return dmItemTypeMapper.getDmItemTypeCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmItemType")
    public Integer qdtxAddDmItemType(@RequestBody DmItemType dmItemType) {
        dmItemType.setCreatedTime(new Date());
        return dmItemTypeMapper.insertDmItemType(dmItemType);
    }

    @PostMapping(value = "/qdtxModifyDmItemType")
    public Integer qdtxModifyDmItemType(@RequestBody DmItemType dmItemType) {
        dmItemType.setUpdatedTime(new Date());
        return dmItemTypeMapper.updateDmItemType(dmItemType);
    }
}
