
## 技术栈
* Zuul - 网关
* Config - 配置中心 -> Git
* Eureka - 注册中心
* Feign - 服务调用
* Ribbon - 客户端负载均衡
* Hystrix - 容错限流
* Sleth - 链式调用

## 部署

### dm-eureka-server单机上伪集群部署[未成功]
修改hosts文件，添加
> 127.0.0.1 eureka1  
> 127.0.0.1 eureka2  

启动[application.bak.yml](./dm-eureka-server/src/main/resources/application.bak.yml)
作为application.yml文件，在两个应用Configuration-Active profiles中分别配置eureka1和eureka2，
并启动应用。

### dm-user-provider单机上伪集群部署
注释[application.yml](./dm-user-provider/src/main/resources/application.yml)中的
server.port，在两个应用Configuration-Overrider Parameters中分别配置
server.port=8081和server.port=8082，并启动应用。

