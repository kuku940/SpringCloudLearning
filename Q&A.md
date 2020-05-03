## 问题汇总

### SpringBoot启动后无法找到对应的bean
SpringBoot默认从启动类所在包开始，扫描当前包及其子包下的所有文件。
Dao和Client等其他bean文件在其他目录下，需要配置相关的扫描路径。

### Feign第一次调用失败
当开启`feign.hystrix.enabled=true`时，当feign调用超过1秒时，会自动报错。
Spring是懒加载机制，在第一次调用时才会加载类，所以一般会超过1秒，导致第一次调用失败

第一种：设置超时时间
```yaml
hystrix:
  command:
    default:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 6000
```
上述放在dm-order-consumer的yml配置中。

第二种：关闭hystrix的超时
```yaml
hystrix:
  command:
    default:
      execution:
        timeout: 
          enabled: false
```

第三种：启动时就加载
```yaml
ribbon:
  eager-load: 
    enabled: true

zuul:
  ribbon: 
    eager-load: 
      enabled: true
```

### 超时配置
```yaml
ribbon:
  ConnectTimeout: 1000  # 连接超时
  ReadTimeout: 1000 # 响应超时
  OkToRetryOnAllOperations: true # 是否发起重试
  MaxAutoRetries: 1 # 当前机器重试1次
  MaxAutoRetriesNextServer: 1 # 当前服务的其他的机器重试1次
```

### 自动刷新配置ConfigBus


### 网关聚合微服务RxJava

