package cn.xiaoyu.dmorderprovider.service;

import cn.xiaoyu.common.dao.mapper.DmOrderLinkUserMapper;
import cn.xiaoyu.common.module.pojo.DmOrderLinkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmOrderLinkUserService {
    @Autowired
    private DmOrderLinkUserMapper dmOrderLinkUserMapper;

    @PostMapping(value = "/getDmOrderLinkUserById")
    public DmOrderLinkUser getDmOrderLinkUserById(@RequestParam("id") Long id) {
        return dmOrderLinkUserMapper.getDmOrderLinkUserById(id);
    }

    @PostMapping(value = "/getDmOrderLinkUserListByMap")
    public List<DmOrderLinkUser> getDmOrderLinkUserListByMap(@RequestParam Map<String, Object> param) {
        return dmOrderLinkUserMapper.getDmOrderLinkUserListByMap(param);
    }

    @PostMapping(value = "/getDmOrderLinkUserCountByMap")
    public Integer getDmOrderLinkUserCountByMap(@RequestParam Map<String, Object> param) {
        return dmOrderLinkUserMapper.getDmOrderLinkUserCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmOrderLinkUser")
    public Integer qdtxAddDmOrderLinkUser(@RequestBody DmOrderLinkUser dmOrderLinkUser) {
        dmOrderLinkUser.setCreatedTime(new Date());
        return dmOrderLinkUserMapper.insertDmOrderLinkUser(dmOrderLinkUser);
    }

    @PostMapping(value = "/qdtxModifyDmOrderLinkUser")
    public Integer qdtxModifyDmOrderLinkUser(@RequestBody DmOrderLinkUser dmOrderLinkUser) {
        dmOrderLinkUser.setUpdatedTime(new Date());
        return dmOrderLinkUserMapper.updateDmOrderLinkUser(dmOrderLinkUser);
    }

    @PostMapping(value = "/deleteDmOrderLinkUserByOrderId")
    public Integer deleteDmOrderLinkUserByOrderId(@RequestParam("orderId") Long orderId) {
        return dmOrderLinkUserMapper.deleteDmOrderLinkUserByOrderId(orderId);
    }
}
