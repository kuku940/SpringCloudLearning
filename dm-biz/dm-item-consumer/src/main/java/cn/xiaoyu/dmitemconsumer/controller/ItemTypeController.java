package cn.xiaoyu.dmitemconsumer.controller;

import cn.xiaoyu.common.common.Dto;
import cn.xiaoyu.common.common.DtoUtil;
import cn.xiaoyu.common.vo.DmItemTypeVo;
import cn.xiaoyu.dmitemconsumer.service.ItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/p/type")
public class ItemTypeController {

    @Autowired
    private ItemTypeService itemTypeService;

    @PostMapping(value = "/queryItemType")
    public Dto<List<DmItemTypeVo>> queryItemType(@RequestBody Map<String, Object> params) {
        Integer parent = Integer.parseInt(params.get("parent").toString());
        List<DmItemTypeVo> list = itemTypeService.queryDmItemTypeByParent(parent);
        return DtoUtil.returnDataSuccess(list);
    }
}
