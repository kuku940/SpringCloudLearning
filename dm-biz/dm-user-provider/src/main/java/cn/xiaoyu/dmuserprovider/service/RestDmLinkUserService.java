package cn.xiaoyu.dmuserprovider.service;

import cn.xiaoyu.common.dao.mapper.DmLinkUserMapper;
import cn.xiaoyu.common.module.pojo.DmLinkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmLinkUserService {
    @Autowired
    private DmLinkUserMapper dmLinkUserMapper;

    @PostMapping(value = "/getDmLinkUserById")
    public DmLinkUser getDmLinkUserById(@RequestParam("id") Long id) {
        return dmLinkUserMapper.getDmLinkUserById(id);
    }

    @PostMapping(value = "/getDmLinkUserListByMap")
    public List<DmLinkUser> getDmLinkUserListByMap(@RequestParam Map<String, Object> param) {
        return dmLinkUserMapper.getDmLinkUserListByMap(param);
    }

    @PostMapping(value = "/getDmLinkUserCountByMap")
    public Integer getDmLinkUserCountByMap(@RequestParam Map<String, Object> param) {
        return dmLinkUserMapper.getDmLinkUserCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmLinkUser")
    public Integer qdtxAddDmLinkUser(@RequestBody DmLinkUser dmLinkUser) {
        dmLinkUser.setCreatedTime(new Date());
        return dmLinkUserMapper.insertDmLinkUser(dmLinkUser);
    }

    @PostMapping(value = "/qdtxModifyDmLinkUser")
    public Integer qdtxModifyDmLinkUser(@RequestBody DmLinkUser dmLinkUser) {
        dmLinkUser.setUpdatedTime(new Date());
        return dmLinkUserMapper.updateDmLinkUser(dmLinkUser);
    }
}
