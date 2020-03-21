package cn.xiaoyu.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 不同楼层的数据封装
 */
@Data
public class DmFloorItems implements Serializable {
    private Integer floor;
    private String itemTypeName;
    private Long itemTypeId;
    private List<DmItemVo> items;
}
