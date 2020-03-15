
## Zuul工程读取Config-Server远程配置信息
### 启用Config-Server配置参数
**1. 添加Config依赖**

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```
**2. 添加配置信息**

添加[bootstrap.yml](./src/main/resources/bootstrap.yml)文件，配置Config-Server服务器，
以及环境分支信息
```yaml
spring:
  application:
    name: dm-gateway-zuul
  cloud:
    config:
      uri: http://localhost:7900
      profile: prod
      lable: master
```

**3. 添加属性**

在类上添加动态属性token

```java
public class PreFilter{
    @Value("${token}")
    private boolean token;
}
```
以上Zuul网关即可读取git上配置的token值，但是如果git值发生改变，上述代码无法感知变化

### 手动刷新，获取git上配置的值
**1. 添加pom依赖**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

**2. 修改配置信息**  

修改[application.yml](./src/main/resources/application.yml)，关闭安全选项
```yaml
management:
  security:
    enabled: false
```

**3. 添加注释@RefreshScope**

为有token值的类添加@RefreshScope注释
```java
@RefreshScope
public class PreFilter{
    @Value("${token}")
    private boolean token;
}
```
Get请求[http://172.25.60.17:7600/refresh](http://172.25.60.17:7600/refresh)手动刷新token值


### 自动刷新 - SpringCloudBus
