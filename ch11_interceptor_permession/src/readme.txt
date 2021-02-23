拦截器检查登录的用户是否能访问系统

步骤：
    1、创建项目，加入依赖
    2、创建controller类
    3、创建普通类，作为拦截器使用
        1）实现HandlerInceptor接口
        2）实现接口中的方法
    4、创建show.jsp
    5、创建login.jsp模拟登录（将登录信息放到session）
        创建logout.jsp模拟退出系统
    6、创建springMVC配置文件
        组件扫描器，扫描@Controller注解
        声明拦截器，之地拦截的请求地址
    7、创建拦截器，以及验证的jsp