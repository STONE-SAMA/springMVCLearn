用户在页面发起一个请求，请求交给springMVC控制器对象，并显示请求处理结果
实现步骤：
	1）加入spring-webmvc依赖、jsp、servlet依赖
	2）重点：在web.xml中注册springMVC框架的核心对象DispatherServlet
		1、DispatherServlet（中央调度器），是一个servlet，其父类继承HttpServlet
		2、DispatherServlet为前端控制器(front controller)
		3、DispatherServlet负责接收用户提交的请求，调用其他的控制器对象，并返回请求结果
	3）创建发起请求界面
	4）创建控制器类
		1、在类上方加入@Controller注解，创建对象，并加入到springMVC容器中
		2、在类上方加入@RequestMapping注解
	5）创建显示请求处理结果的页面
	6）创建springMVC的配置文件
		1、声明组件扫描器，指定@Controller注解所在的包名
		2、声明视图解析器，帮助处理视图