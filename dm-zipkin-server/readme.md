## Sleuth + Zipkin实现接口监控

### 简单实践

#### dm-zipkin-server实践
**1. 添加依赖**

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-server</artifactId>
</dependency>
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-autoconfigure-ui</artifactId>
</dependency>
```

**2. 添加配置**
```yaml
spring:
  application:
    name: dm-zipkin-server
server:
  port: 7800
eureka:
  instance:
    prefer-ip-address: true
    hostname: ${spring.cloud.client.ipAddress}
    instance-id: ${spring.cloud.client.ipAddress}:${spring.application.name}:${server.port}
  client:
    service-url:
      defaultZone: http://root:123456@localhost:7776/eureka/
```

**3. 类上添加@EnableZipkinServer注释**
```java
@EnableZipkinServer
public class DmZipkinServerApplication {
}
```

#### 被监控端实践
**1. 添加依赖**  
在被监控端添加sleuth依赖，[dm-gateway-zuul](../dm-gateway-zuul), 
[dm-user-consumer](../dm-user-consumer), [dm-user-provider](../dm-user-provider)
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```

**2. 添加配置**

被监控端添加如下配置
```yaml
spring:
  sleuth:
    sampler:
      percentage: 1.0
  zipkin:
    base-url: http://zipkin:7800
```
hosts文件添加`127.0.0.1 zipkin`

登录请求，然后访问[http://127.0.0.1:7800/](http://127.0.0.1:7800/)可以访问zipkin来
获取sleuth数据追踪。

### 小结

#### 使用消息中间件收集数据
上述实践是通过Http请求方式，需要和各个服务耦合，网络波动下可能会导致
数据丢失。此时可以通过消息中间的方式来解决，将需要收集的数据线发送到
消息中间件如RabbitMQ中，然后ZipkinServer再从消息中间件中取出数据分析。
