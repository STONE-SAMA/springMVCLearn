处理器方法的返回值表示处理结果

ModelAndView 有数据和视图，对视图执行forward
String 表示视图，可以是逻辑名称，也可是完整视图路径
void 不能表示数据、视图
    在处理ajax时，可以使用void返回值。通过HttpServletResponse输出数据，响应ajax请求
    ajax请求服务器端返回的就是数据，和视图无关
Object  例如String、Integer等都是对象
    对象有属性，属性就是数据。所以返回Object表示数据，与视图无关
    可以使用对象表示数据，响应ajax请求

    ajax主要使用json数据格式。实现步骤：
        1、加入处理json的工具库依赖，springMVC默认使用jackson
        2、在springMVC配置文件键加入<mvc:annotation-driven>注解驱动
            json = om.writeValueAsString(student);
        3、在处理器方法上加入@ResponseBody注解
            response.setContentType("application/json;charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.println(json);

    springMVC处理对象方法返回Object，可以转化为json输出到浏览器，响应ajax的内部原理
    1、<mvc:annotation-driven>注解驱动
        注解驱动实现的功能是 完成java对象到json、xml、text、二进制数据格式的转换
        HttpMessageConverter接口：消息转换器
            功能：定义了java转为json，xml等数据格式的方法
                其实现类完成java对象到json、xml、二进制数据的转换

        <mvc:annotation-driven>在加入到springmvc配置文件后，会自动创建HttpMessageConverter接口
        的7个实现类对象，包括MappingJackson2HttpMessageConverter（使用jackson工具库中的ObjectMapper实现java对象转为json字符串）

    以下两个方法是控制器类将输出结果输出给浏览器时使用：
        boolean canWrite(Class<?> var1, @Nullable MediaType var2);
        void write(T var1, @Nullable MediaType var2, HttpOutputMessage var3)
    1）canWrite检查处理器方法的返回值，能不能转为var2表示的数据格式
    2）write 将处理器方法的返回值对象，调用jackson中的objectMapper转为json字符串