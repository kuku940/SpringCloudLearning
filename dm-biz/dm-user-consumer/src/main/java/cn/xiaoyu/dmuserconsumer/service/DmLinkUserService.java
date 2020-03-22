package cn.xiaoyu.dmuserconsumer.service;

import cn.xiaoyu.common.vo.QueryLinkUserVo;

import java.util.List;

public interface DmLinkUserService {

    /**
     * 根据当前登陆的用户ID获取常用联系人
     */
    List<QueryLinkUserVo> findLinkUserByUserId(Long userId);
}
