package cn.xiaoyu.dmschedulerconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.xiaoyu.*"})
@ComponentScan(basePackages = {"cn.xiaoyu.*"})
public class DmSchedulerConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DmSchedulerConsumerApplication.class, args);
    }
}
