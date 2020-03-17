package cn.xiaoyu.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 日志工具类
 */
@Component
public class LogUtils {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void i(String topic, String msg) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        threadPool.execute(() -> kafkaTemplate.send(topic, "dm", msg));
    }
}
