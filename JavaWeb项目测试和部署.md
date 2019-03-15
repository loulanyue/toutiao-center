单元测试

打包

部署

总结

扩展

单元测试

测试四部曲

    1.初始化数据
    2.执行要测试的业务
    3.验证测试的数据
    4.清理数据

打包

    1.application继承SpringBootServletInitializer
    2.pom.xml打包改为war
    3.mvn package -Dmaven.test.skip=ture
    4.去除多余的main函数

    @SpringBootApplication
    public class ToutiaoApplication extends SpringBootServletInitializer{
      @Override
      protected SpringBootApplicationBuildder configure(SpringApplicationBuilder builder){
        return builder.sources(ToutiaoApplication.class);
      }
      public static void main(String[] args){
        SpringApplication.run(ToutiaoApplication.class,args);
      }
    }

    http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-create-a-deployable-war-file


部署

    服务器安装
    apt-get install nginx mysql-srver libmysqlclient-dev maven redis

    启动WEB:tomcat目录增加执行权限。chmod+x startup.sh
    配置Java:update-alternatives -config java
    Redis链接修改

Nginx配置 /etc/nginx/sites-enabled/c2

    server{
      listen 80;
      server_name c2.coder.com;
      location/{
        proxy_pass http://127.0.0.1:8080;
      }
    }


总结

    1.开发工具Git,IntilliJ
    2.SpringBoot,Velocity
    3.myBatis
    4.登陆/注册
    5.云存储SDK
    6.Redis
    7.邮件
    8.单元测试/部署

扩展

产品功能扩展

    1.用户注册，邮箱激活流程
    
    2.站内信互发
    
    3.首页滚动到底部自动加载更多
    
    4.管理员后台管理
    
    5.运营推荐置顶
    
    6.广告推广(smzdm.com)
    
    7.SNS关注，个性化首页

技术深度扩展

    1.自定义排序
    2.缩图服务
    3.爬虫自动填充资讯
    4.个性化推荐

myBatis和数据库

MVC,前后端分离，模板

单元测试

云SDK接入

AJAX

Spring框架

Git工具
