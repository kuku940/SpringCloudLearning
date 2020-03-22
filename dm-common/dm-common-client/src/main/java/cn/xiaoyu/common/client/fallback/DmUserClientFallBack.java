package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmUserClient;
import cn.xiaoyu.common.module.pojo.DmUser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmUserClientFallBack implements RestDmUserClient {
    @Override
    public DmUser getDmUserById(Long id) {
        return null;
    }

    @Override
    public List<DmUser> getDmUserListByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer getDmUserCountByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer qdtxAddDmUser(DmUser dmUser) {
        return null;
    }

    @Override
    public Integer qdtxModifyDmUser(DmUser dmUser) {
        return null;
    }

    @Override
    public DmUser findByWxUserId(String wxUserId) {
        return null;
    }

    @Override
    public Long createDmUser(DmUser dmUser) {
        return null;
    }

    @Override
    public DmUser checkLoginByPassword(DmUser dmUser) {
        return null;
    }

    @Override
    public String generateToken(DmUser dmUser) {
        return null;
    }
}
