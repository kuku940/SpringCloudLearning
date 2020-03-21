package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/***
 *   节目表
 */
@Data
public class DmItem implements Serializable {
    //
    private Long id;
    //节目名称
    private String itemName;
    //摘要信息
    private String abstractMessage;
    //节目类型管理ID
    private Long itemType1Id;
    //节目名称
    private String itemType1Name;
    //节目类型管理ID
    private Long itemType2Id;
    //节目名称
    private String itemType2Name;
    //状态(1:项目待定2:预售/预订3:开始售票4:演出开始)
    private Integer state;
    //基础描述
    private String basicDescription;
    //项目描述
    private String projectDescription;
    //温馨提示
    private String reminderDescription;
    //经度
    private String longitude;
    //纬度
    private String latitude;
    //是否推荐(0:默认 1:热推)
    private Integer isBanner;
    //是否推荐(0:不推荐 1:推荐)
    private Integer isRecommend;
    //平均分
    private Double avgScore;
    //评论数目
    private Integer commentCount;
    //剧场Id
    private Long cinemaId;
    //开始演出时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //最低价格
    private Double minPrice;
    //最高价格
    private Double maxPrice;
    //年龄段（0:全年龄段,1:0-3岁,2:3-6岁,3:6-12岁）
    private Integer ageGroup;
    //创建时间
    private Date createdTime;
    //更新时间
    private Date updatedTime;
}
