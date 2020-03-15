package cn.xiaoyu.dmorderprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DmOrderProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DmOrderProviderApplication.class, args);
    }
}
