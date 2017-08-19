# springboot-quartz
这个项目基于springboot-mybatis生成，将其中的quartz插件单独提出来生成

20170816：

1.添加springboot 跨域配置

2.集成easyui，定时任务界面化

访问路径：

1.可以直接访问页面（页面修改不用重启服务，实现前后端分离）

http://localhost:63342/springboot-quartz/static/quartzIndex.html

2.启动项目访问页面（修改页面需要重启服务，编译后生效，相当于集成开发）

http://localhost:1111/quartzIndex.html

![image](https://github.com/a736875071/springboot-quartz/blob/master/src/main/resources/static/list.png)
![image](https://github.com/a736875071/springboot-quartz/blob/master/src/main/resources/static/add.png)

20170819：

1.将之前代码中重复代码删除，只保留其中与页面集成的接口

注：quartz.properties中集群配置在暂停一段时间后，再恢复会将暂停这段时间内没有执行的任务重新执行，暂没找到好的解决办法