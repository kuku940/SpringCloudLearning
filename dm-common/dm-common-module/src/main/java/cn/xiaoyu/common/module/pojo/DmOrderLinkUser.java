package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *   订单联系人表
 */
@Data
public class DmOrderLinkUser implements Serializable {
    //主键
    private Long id;
    //订单id
    private Long orderId;
    //联系人id
    private Long linkUserId;
    //入住人姓名逗号分隔
    private String linkUserName;
    //
    private Integer x;
    //
    private Integer y;
    //价格
    private Double price;
    //
    private Date createdTime;
    //
    private Long updatedTime;
}
