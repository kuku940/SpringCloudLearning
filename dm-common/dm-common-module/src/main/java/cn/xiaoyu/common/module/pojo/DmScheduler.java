package cn.xiaoyu.common.module.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *   节目排期表
 */
@Data
public class DmScheduler implements Serializable {
    //
    private Long id;
    //排期名称
    private String title;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //剧集Id
    private Long itemId;
    //剧场Id
    private Long cinemaId;
    //创建时间
    private Date createdTime;
    //更新时间
    private Date updatedTime;
}
