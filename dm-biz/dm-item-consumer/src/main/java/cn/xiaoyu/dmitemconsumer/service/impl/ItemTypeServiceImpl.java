package cn.xiaoyu.dmitemconsumer.service.impl;

import cn.xiaoyu.common.client.client.RestDmItemTypeClient;
import cn.xiaoyu.common.module.pojo.DmItemType;
import cn.xiaoyu.common.utils.EmptyUtils;
import cn.xiaoyu.common.vo.DmItemTypeVo;
import cn.xiaoyu.dmitemconsumer.service.ItemTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现类
 */
@Component
public class ItemTypeServiceImpl implements ItemTypeService {

    @Autowired
    private RestDmItemTypeClient dmItemTypeClient;

    /**
     * 根据parent查询DmItemType
     */
    @Override
    public List<DmItemTypeVo> queryDmItemTypeByParent(Integer parent) {
        Map<String, Object> param = new HashMap<>();
        param.put("parent", parent);
        List<DmItemType> dmItemTypeList = dmItemTypeClient.getDmItemTypeListByMap(param);
        List<DmItemTypeVo> dmItemTypeVos = new ArrayList<>();
        if (EmptyUtils.isNotEmpty(dmItemTypeList)) {
            for (DmItemType itemType : dmItemTypeList) {
                DmItemTypeVo dmItemTypeVo = new DmItemTypeVo();
                BeanUtils.copyProperties(itemType, dmItemTypeVo);
                dmItemTypeVos.add(dmItemTypeVo);
            }
        }
        return dmItemTypeVos;
    }
}
