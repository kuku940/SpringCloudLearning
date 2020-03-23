### 各服务直接与Zipkin Server连接问题

* 耦合性：所有服务都需要连接到Zipkin Server;  
* 不稳定型：网络出现问题就无法保证收集到跟踪数据。

**解决方案**：
可以将收集到的数据发送到消息中间件，然后Zipkin Server再从消息中间件中取出数据分析

### Zipkin Server整合Rabbit Mq

#### Zipkin服务端配置
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

#### Zipkin客户端配置

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

### 跟踪数据持久化
ZipkinServer的数据都是存储在内存中，如果重启Zipkin Server之前的数据就无法查看
所以需要将zipkin的数据进行持久化。
可以存储到`mysql/ES`等持久化数据。

#### 将Zipkin跟踪数据持久化到Mysql中

**1. 添加pom依赖**
```xml
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-storage-mysql</artifactId>
    <version>1.16.2</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

**2. 创建数据库**  
创建数据库dm_zipkin，[sql脚本地址](https://github.com/openzipkin/zipkin/blob/master/zipkin-storage/mysql-v1/src/main/resources/mysql.sql)

**3. 修改配置文件**  
为应用添加数据源配置，并指定存储方式为mysql
```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/dm_zipkin?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull
    username: root
    password: 123456
    driver-class-name: org.gjt.mm.mysql.Driver
zipkin: 
  storage:
    type: mysql
```