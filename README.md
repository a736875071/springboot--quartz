# springboot-quartz
这个项目基于springboot-mybatis生成，将其中的quartz插件单独提出来生成

注：启动项目前请将resources/sql/quartz.sql导入数据库

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

20170820：

1.将之前的一个定时任务执行类改为两个（ScheduledJob和HelloJob），可以根据任务类名进行选择执行那个任务类

![image](https://github.com/a736875071/springboot-quartz/blob/master/src/main/resources/static/list2.png)
![image](https://github.com/a736875071/springboot-quartz/blob/master/src/main/resources/static/add2.png)

20170903：

Spring Boot的默认配置方式，提供的静态资源映射如下:

classpath:/META-INF/resources
classpath:/resources
classpath:/static
classpath:/public

优先级顺序为：META-INF/resources > resources > static > public

默认值为

spring.mvc.static-path-pattern=

默认值为 classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/

spring.resources.static-locations=这里设置要指向的路径，多个使用英文逗号隔开

我们可以通过修改spring.mvc.static-path-pattern来修改默认的映射，例如我改成/xxx/**,

那运行的时候访问 http://lcoalhost:8080/xxx/index.html 才对应到index.html页面。