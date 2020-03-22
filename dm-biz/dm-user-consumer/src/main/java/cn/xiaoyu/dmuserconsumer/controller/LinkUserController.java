package cn.xiaoyu.dmuserconsumer.controller;


import cn.xiaoyu.common.common.Dto;
import cn.xiaoyu.common.common.DtoUtil;
import cn.xiaoyu.common.vo.DmUserVo;
import cn.xiaoyu.common.vo.QueryLinkUserVo;
import cn.xiaoyu.dmuserconsumer.service.DmLinkUserService;
import cn.xiaoyu.dmuserconsumer.service.DmLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LinkUserController {
    @Autowired
    private DmLoginService dmLoginService;
    @Autowired
    private DmLinkUserService dmLinkUserService;

    @PostMapping(value = "/v/queryLinkUser")
    public Dto queryLinkUserByUserId(HttpServletRequest request) {
        String tokenString = request.getHeader("token");
        //根据用户TOKEN获取当前联系人的信息
        DmUserVo dmUserVO = dmLoginService.loadCurrentUserByTokenAsDmUserVo(tokenString);
        //根据当前登陆的用户ID获取常用联系人
        List<QueryLinkUserVo> queryLinkUserVos = dmLinkUserService.findLinkUserByUserId(dmUserVO.getUserId());
        return DtoUtil.returnDataSuccess(queryLinkUserVos);
    }
}
