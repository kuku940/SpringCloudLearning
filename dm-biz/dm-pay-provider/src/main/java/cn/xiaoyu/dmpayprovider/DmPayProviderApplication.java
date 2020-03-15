package cn.xiaoyu.dmpayprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DmPayProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DmPayProviderApplication.class, args);
    }
}
