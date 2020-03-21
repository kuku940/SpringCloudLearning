package cn.xiaoyu.dmpayconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.xiaoyu.common.*"})
@ComponentScan(basePackages = {"cn.xiaoyu.common.*"})
public class DmPayConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DmPayConsumerApplication.class, args);
    }
}
