# spring-example
```text
spring boot开发脚手架，后端采用spring boot 2.x，前端采用vue
前端项目支持两种部署方式，1.将vue项目build 后将dist文件copy到nginx下，访问项目。2.将vue项目build 后将dist文件copy到spring boot项目的resource/static下，启动spring boot项目访问根目录即可

```


## redis
```text
实现spring boot集成redis 并且实现对redis操作工具类
实现redis管理session ，使用httpsesion进行操作即可实现

```

## ldap
```text
实现ldap协议的登录方式
```

## rabbitmq
```text
实现rabbitmq交换机、队列的创建、绑定
实现对交换机、队列生成数据
实现消费数据
安装插件 （安装命令：rabbitmq-plugins enable rabbitmq_web_stomp ）实现web 页面通过socket消费消息


```
