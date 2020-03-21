package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmCinemaClient;
import cn.xiaoyu.common.module.pojo.DmCinema;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DmCinemaClientFallBack implements RestDmCinemaClient {
    @Override
    public DmCinema getDmCinemaById(Long id) {
        return null;
    }

    @Override
    public List<DmCinema> getDmCinemaListByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer getDmCinemaCountByMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public Integer qdtxAddDmCinema(DmCinema dmCinema) {
        return null;
    }

    @Override
    public Integer qdtxModifyDmCinema(DmCinema dmCinema) {
        return null;
    }
}
