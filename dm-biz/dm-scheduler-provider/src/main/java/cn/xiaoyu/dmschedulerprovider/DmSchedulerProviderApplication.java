package cn.xiaoyu.dmschedulerprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.xiaoyu.common.dao")
public class DmSchedulerProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DmSchedulerProviderApplication.class, args);
    }
}
