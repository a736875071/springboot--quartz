# springboot-quartz
这个项目基于springboot-mybatis生成，将其中的quartz插件单独提出来生成，所以在com.controller.cm.quartz.QuartzContrlloer和
com.service.cm.quartz.config.SchedulerListener中手动添加properties文件，
如果不需要更改properties中内容可以在resource下创建properties文件

20170816
1.添加springboot 跨域配置

2.集成easyui，定时任务界面化

访问路径：
1.可以直接访问页面

http://localhost:63342/springboot-quartz/static/quartzIndex.html

2.启动项目通过

localhost:1111/quartzIndex.html

![image](https://github.com/a736875071/springboot-quartz/blob/master/src/main/resources/static/list.png)
![image](https://github.com/a736875071/springboot-quartz/blob/master/src/main/resources/static/add.png)