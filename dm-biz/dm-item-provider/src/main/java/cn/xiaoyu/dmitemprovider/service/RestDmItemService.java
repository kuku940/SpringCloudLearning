package cn.xiaoyu.dmitemprovider.service;

import cn.xiaoyu.common.dao.mapper.DmItemMapper;
import cn.xiaoyu.common.module.pojo.DmItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmItemService {
    @Autowired
    private DmItemMapper dmItemMapper;

    @PostMapping(value = "/getDmItemById")
    public DmItem getDmItemById(@RequestParam("id") Long id) {
        return dmItemMapper.getDmItemById(id);
    }

    @PostMapping(value = "/getDmItemListByMap")
    public List<DmItem> getDmItemListByMap(@RequestParam Map<String, Object> param) {
        return dmItemMapper.getDmItemListByMap(param);
    }

    @PostMapping(value = "/getDmItemCountByMap")
    public Integer getDmItemCountByMap(@RequestParam Map<String, Object> param) {
        return dmItemMapper.getDmItemCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmItem")
    public Integer qdtxAddDmItem(@RequestBody DmItem dmItem) {
        dmItem.setCreatedTime(new Date());
        return dmItemMapper.insertDmItem(dmItem);
    }

    @PostMapping(value = "/qdtxModifyDmItem")
    public Integer qdtxModifyDmItem(@RequestBody DmItem dmItem) {
        dmItem.setUpdatedTime(new Date());
        return dmItemMapper.updateDmItem(dmItem);
    }
}
