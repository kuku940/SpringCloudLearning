
### dm-user-provider单机上伪集群部署
注释[application.yml](./dm-user-provider/src/main/resources/application.yml)中的
server.port，在两个应用Configuration-Overrider Parameters中分别配置
server.port=8081和server.port=8082，并启动应用。



