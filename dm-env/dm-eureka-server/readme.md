
### dm-eureka-server单机上伪集群部署[未成功]
修改hosts文件，添加
> 127.0.0.1 eureka1  
> 127.0.0.1 eureka2  

启动[application.bak.yml](./dm-eureka-server/src/main/resources/application.bak.yml)
作为application.yml文件，在两个应用Configuration-Active profiles中分别配置eureka1和eureka2，
并启动应用。

### eureka-server访问加密

**1. 添加pom依赖**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

**2. 修改配置文件**
```yaml
security:
  basic:
    enabled: true
  user:
    name: root
    password: 123456
```

以上完成访问加密，通过[http://localhost:7776/](http://localhost:7776/)访问会要求密码，
可以通过[http://root:123456@localhost:7776/](http://root:123456@localhost:7776/)访问。

### eureka注册的服务注销慢
当一个服务关闭时，其在eureka上的节点还会依然存在很久。可以通过如下配置保证服务快速注销

配置eureka服务端[application.yml](./src/main/resources/application.yml),
关闭自我保护（生产环境要开启自我保护）以及提高刷新时间为2秒，默认90秒注销。
```yaml
eureka:
  server:
    enable-self-preservation: false
    evication-interval-timer-in-ms: 2000
```

配置客户端yml文件
```yaml
eureka:
  instance: 
    lease-expiration-duration-in-seconds: 2
    lease-renewal-interval-in-seconds: 2
``` 
