## 技术栈
* Zuul - 网关
* Config - 配置中心 -> Git
* Eureka - 注册中心
* Feign - 服务调用
* Ribbon - 客户端负载均衡
* Hystrix - 容错限流
* Sleuth + Zipkin - 链式调用

参考[SpringCloud架构设计](./resources/SpringCloud架构设计.md)

## 模块介绍

**1. Common - 基础模块**
* dm-common-client
* dm-common-dao
* dm-common-module
* dm-common-ext-utils
* dm-common-utils
* dm-common-dto

**2. EnvProject - 环境工程**
* dm-gateway-zuul   `8080`
* dm-config-server  `7900`
* dm-eureka-server  `7776`
* dm-zipkin-server  `7800`

**3. BizProject - 业务模块**
* dm-base-consumer `9010`| dm-base-provider `9210`
* dm-user-consumer `9020`| dm-user-provider `9220`
* dm-order-consumer `9030`| dm-order-provider `9230`
* dm-item-consumer `9040`| dm-item-provider `9240`
* dm-pay-consumer `9050`| dm-pay-provider `9250`
* dm-scheduler-consumer `9060`| dm-scheduler-provider `9260`
