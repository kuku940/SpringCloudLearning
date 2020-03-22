package cn.xiaoyu.dmuserconsumer.service.impl;

import cn.xiaoyu.common.client.client.RestDmLinkUserClient;
import cn.xiaoyu.common.module.pojo.DmLinkUser;
import cn.xiaoyu.common.vo.QueryLinkUserVo;
import cn.xiaoyu.dmuserconsumer.service.DmLinkUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DmLinkUserServiceImpl implements DmLinkUserService {
    @Autowired
    private RestDmLinkUserClient restDmLinkUserClient;

    @Override
    public List<QueryLinkUserVo> findLinkUserByUserId(Long userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        List<DmLinkUser> dmLinkUsers = restDmLinkUserClient.getDmLinkUserListByMap(params);
        List<QueryLinkUserVo> queryLinkUserVos = new ArrayList<>();
        if (!dmLinkUsers.isEmpty()) {
            //组装数据
            for (DmLinkUser dmLinkUser : dmLinkUsers) {
                QueryLinkUserVo queryLinkUserVo = new QueryLinkUserVo();
                BeanUtils.copyProperties(dmLinkUser, queryLinkUserVo);
                queryLinkUserVos.add(queryLinkUserVo);
            }
        }
        return queryLinkUserVos;
    }
}
