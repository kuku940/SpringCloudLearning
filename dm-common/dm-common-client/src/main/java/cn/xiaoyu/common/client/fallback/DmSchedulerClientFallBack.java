package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmSchedulerClient;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.common.module.pojo.DmScheduler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmSchedulerClientFallBack implements RestDmSchedulerClient {
    @Override
    public DmScheduler getDmSchedulerById(Long id) throws BizException {
        return null;
    }

    @Override
    public List<DmScheduler> getDmSchedulerListByMap(Map<String, Object> param) throws BizException {
        return null;
    }

    @Override
    public Integer getDmSchedulerCountByMap(Map<String, Object> param) throws BizException {
        return null;
    }

    @Override
    public Integer qdtxAddDmScheduler(DmScheduler dmScheduler) throws BizException {
        return null;
    }

    @Override
    public Integer qdtxModifyDmScheduler(DmScheduler dmScheduler) throws BizException {
        return null;
    }
}
