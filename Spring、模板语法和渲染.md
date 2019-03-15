SpringBoot工程

参数解析

HTTP Method

Velocity

Request/Response/Session

Error/重定向

Logger

IoC

AOP/Aspect


SpringBoot

最简单的服务器

    web请求
    
    controller
    
    Service
    
    DAO
    
    Database
    

    @Controller
    public class IndexController{
      @RequestMapping("/");
      @ResponseBody
      public String index(){
        return "Hello";
      }
    }

    @RequestMapping(value="/profile{groupId}/{userId}")
    @ResponseBody
    public String profile(@PathVariable("groupId")String groupId,
                @PathVariable("userId") int userId,
                @RequestParam(value="type",defaultValue="1") int type,
                @RequestParam(value="key",defaultValue="coder")String key){
                  return String.format("{%s},{%d},{%d},{%s}",groupId,userId,type,key);
                }


HTTP Method

    GET	获取接口信息
    
    PUT 支持幂等性的POST
    
    HEAD 紧急查看接口HTTP的头
    
    DELETE 删除服务器上的资源
    
    POST 提交数据到服务器
    
    OPITIONS 查看支持的方法

    一般网站只用Get和Post，代表获取和更新，html的form仅支持Get和Post

静态和模板文件

静态

    默认目录：static/templates
    文件：css/js/images

模板文件

    默认目录：templates
    文件：xxx.vm

Velocity模板语法（类似Java语法）

    $!{变量/表达式}
    ##注释###*多行注释*#

for

    #foreach($color in $colors)
    Color$!(foreach.count)/$(foreach.index):$!{color}
    #end

Velocity语法

    属性访问
    $!{user.name}
    $!{user.getName()}

模板继承

    include 纯文本扩展
    parse变量解析

macro

    #macro(render_color,$color,$index)
    This is Color $index:$color
    #end

    #foreach($color in $colors)
      #render_color($color,$foreach.index)
    #end

request/response

request

    参数解析
    cookie读取
    http请求字段
    文件上传

response

    页面内容返回
    cookie下发
    http字段设置，headers

HttpServletResponse

    response.addCookie(new Cookir(key,value));
    response.addHeader(key,value);

HttpServletRequest

    request.getHeaderNames();
    request.getMethod();
    request.getPathInfo();
    request.getQueryString();

重定向

    重定向
    301：永久转移
    302：临时转移

Error

    //Spring MAV外的Exception或Spring MVC没有处理的Exception
    @ExceptionHander()
    @ResponseBody
    public String error(Exception e){
      return "ERROR:"+e.getMessage();
    }

IoC

    Traditional
    Dependency Injected

AOP/Log

    面向切面，所有业务都要处理的业务
    private static final Logger logger =LoggerFactory.getLogger(IndexController.class);

    @Before("execution(* com.coder.controller.IndexController.*(...))")
    public void beforeMethod(JoinPoint joinPoint){
      logger.info("before"+joinPoint.toLongString());
    }
