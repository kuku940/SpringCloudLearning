package cn.xiaoyu.common.vo;

import lombok.Data;

@Data
public class QueryLinkUserVo {
    //表的主键
    private Long id;
    //联系人姓名
    private String name;
    //身份证号
    private String idCard;
    //证件类型(0:身份证 1:护照)
    private Integer cardType;
}
