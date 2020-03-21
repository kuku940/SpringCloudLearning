package cn.xiaoyu.common.client.fallback;

import cn.xiaoyu.common.client.client.RestDmRegisterClient;
import org.springframework.stereotype.Component;

@Component
public class DmRegisterClientFallBack implements RestDmRegisterClient {

    @Override
    public String generateVerificationCode() {
        return null;
    }
}
