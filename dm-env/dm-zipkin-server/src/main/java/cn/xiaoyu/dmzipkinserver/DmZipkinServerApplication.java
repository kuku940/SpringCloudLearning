package cn.xiaoyu.dmzipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class DmZipkinServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DmZipkinServerApplication.class, args);
    }
}

