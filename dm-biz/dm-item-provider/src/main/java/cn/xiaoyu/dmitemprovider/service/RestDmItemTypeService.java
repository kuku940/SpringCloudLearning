package cn.xiaoyu.dmitemprovider.service;

import cn.xiaoyu.common.dao.mapper.DmItemTypeMapper;
import cn.xiaoyu.common.module.pojo.DmItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmItemTypeService {

    @Autowired
    private DmItemTypeMapper dmItemTypeMapper;

    @RequestMapping(value = "/getDmItemTypeById", method = RequestMethod.POST)
    public DmItemType getDmItemTypeById(@RequestParam("id") Long id) throws Exception {
        return dmItemTypeMapper.getDmItemTypeById(id);
    }

    @RequestMapping(value = "/getDmItemTypeListByMap", method = RequestMethod.POST)
    public List<DmItemType> getDmItemTypeListByMap(@RequestParam Map<String, Object> param) throws Exception {
        return dmItemTypeMapper.getDmItemTypeListByMap(param);
    }

    @RequestMapping(value = "/getDmItemTypeCountByMap", method = RequestMethod.POST)
    public Integer getDmItemTypeCountByMap(@RequestParam Map<String, Object> param) throws Exception {
        return dmItemTypeMapper.getDmItemTypeCountByMap(param);
    }

    @RequestMapping(value = "/qdtxAddDmItemType", method = RequestMethod.POST)
    public Integer qdtxAddDmItemType(@RequestBody DmItemType dmItemType) throws Exception {
        dmItemType.setCreatedTime(new Date());
        return dmItemTypeMapper.insertDmItemType(dmItemType);
    }

    @RequestMapping(value = "/qdtxModifyDmItemType", method = RequestMethod.POST)
    public Integer qdtxModifyDmItemType(@RequestBody DmItemType dmItemType) throws Exception {
        dmItemType.setUpdatedTime(new Date());
        return dmItemTypeMapper.updateDmItemType(dmItemType);
    }
}
