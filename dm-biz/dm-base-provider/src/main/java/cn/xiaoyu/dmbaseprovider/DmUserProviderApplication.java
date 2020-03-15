package cn.xiaoyu.dmbaseprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DmUserProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DmUserProviderApplication.class, args);
    }
}
