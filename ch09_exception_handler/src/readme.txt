exception-handler异常处理

异常处理步骤：
1、在项目中加入依赖
2、新建自定义异常类，再定义其子类
3、在controller抛出异常
4、创建普通类，作为全局异常处理类
    1）在类上加入@ControllerAdvice
    2）在类中定义方法，方法上方加入@ExceptionHandler
5、处理异常的视图界面
6、创建springMVC的配置文件
    1）组件扫描器，扫描@Controller注解
    2）组件扫描器，扫描@ControllerAdvice所在包名
    3）声明注解驱动
