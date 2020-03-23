## 各服务直接与Zipkin Server连接问题

* 耦合性：所有服务都需要连接到Zipkin Server;  
* 不稳定型：网络出现问题就无法保证收集到跟踪数据。

**解决方案**：
可以将收集到的数据发送到消息中间件，然后Zipkin Server再从消息中间件中取出数据分析

## Zipkin Server整合Rabbit Mq

### Zipkin服务端配置
**1. 添加pom依赖**  
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-sleuth-zipkin-stream</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-stream-binder-rabbit</artifactId>
</dependency>
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-autoconfigure-ui</artifactId>
</dependency>
```
**2. 修改配置文件**  
```yaml
spring: 
  rabbitmq:
    host: 127.0.0.1
    port: 5672
    username: guest
    password: guest
```

**3. 修改启动类**  
将`@EnableZipkinServer`修改为`@EnableZipkinStreamServer`

### Zipkin客户端配置

**1. 添加pom依赖**  
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-sleuth-stream</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-stream-binder-rabbit</artifactId>
</dependency>
```

**2. 修改配置文件**  
```yaml
spring: 
  rabbitmq:
    host: 127.0.0.1
    port: 5672
    username: guest
    password: guest
```