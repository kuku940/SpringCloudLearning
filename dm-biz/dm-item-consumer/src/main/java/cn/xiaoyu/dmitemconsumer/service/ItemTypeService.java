package cn.xiaoyu.dmitemconsumer.service;

import cn.xiaoyu.common.vo.DmItemTypeVo;

import java.util.List;

/***
 * 节目类型Service
 */
public interface ItemTypeService {
    /**
     * 根据父级节点查询类型列表
     */
    List<DmItemTypeVo> queryDmItemTypeByParent(Integer parent);
}
