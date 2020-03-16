package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmCinemaSeatClient;
import cn.xiaoyu.common.exception.BizException;
import cn.xiaoyu.common.module.pojo.DmCinemaSeat;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmCinemaSeatClientFallBack implements RestDmCinemaSeatClient {
    @Override
    public DmCinemaSeat getDmCinemaSeatById(Long id) throws BizException {
        return null;
    }

    @Override
    public List<DmCinemaSeat> getDmCinemaSeatListByMap(Map<String, Object> param) throws BizException {
        return null;
    }

    @Override
    public Integer getDmCinemaSeatCountByMap(Map<String, Object> param) throws BizException {
        return null;
    }

    @Override
    public Integer qdtxAddDmCinemaSeat(DmCinemaSeat dmCinemaSeat) throws BizException {
        return null;
    }

    @Override
    public Integer qdtxModifyDmCinemaSeat(DmCinemaSeat dmCinemaSeat) throws BizException {
        return null;
    }
}
