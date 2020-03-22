package cn.xiaoyu.dmuserprovider.service;

import cn.xiaoyu.common.dao.mapper.DmUserMapper;
import cn.xiaoyu.common.module.pojo.DmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmUserService {

    @Autowired
    private DmUserMapper dmUserMapper;

    @PostMapping(value = "/getDmUserById")
    public DmUser getDmUserById(@RequestParam("id") Long id) {
        return dmUserMapper.getDmUserById(id);
    }

    @PostMapping(value = "/getDmUserListByMap")
    public List<DmUser> getDmUserListByMap(@RequestParam Map<String, Object> param) {
        return dmUserMapper.getDmUserListByMap(param);
    }

    @PostMapping(value = "/getDmUserCountByMap")
    public Integer getDmUserCountByMap(@RequestParam Map<String, Object> param) {
        return dmUserMapper.getDmUserCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmUser")
    public Integer qdtxAddDmUser(@RequestBody DmUser dmUser) {
        dmUser.setCreatedTime(new Date());
        return dmUserMapper.insertDmUser(dmUser);
    }

    @PostMapping(value = "/qdtxModifyDmUser")
    public Integer qdtxModifyDmUser(@RequestBody DmUser dmUser) {
        dmUser.setUpdatedTime(new Date());
        return dmUserMapper.updateDmUser(dmUser);
    }

    @PostMapping(value = "/checkLoginByPassword")
    public DmUser checkLoginByPassword(@RequestBody DmUser dmUser) {
        return dmUserMapper.checkLoginByPassword(dmUser.getPhone(), dmUser.getPassword());
    }
}
