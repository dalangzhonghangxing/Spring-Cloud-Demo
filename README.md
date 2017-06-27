该项目是一个简单的考试系统，分为考题管理页面和考试页面。
运行前需要创建数据库examination，在运行时先启动Test-Service，在启动Account-Service。
前端git地址为 git@github.com:dalangzhonghangxing/Spring-Cloud-Demo-front-end.git 。由于重点在Spring-Cloud，因此前端界面只用了基本的bootstrap风格，采用AngularJS框架。
系统会初始化两个账号：
管理员。账号:admin，密码:admin
考生。账号:tester，密码:tester
在登录页面能够查看eureka对各个服务的监控。
管理员账号登陆后会进入考题管理页面，对考题进行增删改查。
考生登录后系统会自动出题，并进行考题。

任务难点：
1、搭建整个微服务平台。
2、解决跨域问题。
3、由于没有Redis，模拟了一个Session。

在本次大作业中，四位小组成员共同设计，遇到问题一起查阅资料，一起解决，贡献均等。
