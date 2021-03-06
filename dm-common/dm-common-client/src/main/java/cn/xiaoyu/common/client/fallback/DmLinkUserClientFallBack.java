package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmLinkUserClient;
import cn.xiaoyu.common.module.pojo.DmLinkUser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmLinkUserClientFallBack implements RestDmLinkUserClient {

    @Override
    public DmLinkUser getDmLinkUserById(Long id) {
        return null;
    }

    @Override
    public List<DmLinkUser> getDmLinkUserListByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer getDmLinkUserCountByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer qdtxAddDmLinkUser(DmLinkUser dmLinkUser) {
        return null;
    }

    @Override
    public Integer qdtxModifyDmLinkUser(DmLinkUser dmLinkUser) {
        return null;
    }

    @Override
    public Integer deleteDmLinkUserById(Long id) {
        return null;
    }
}
