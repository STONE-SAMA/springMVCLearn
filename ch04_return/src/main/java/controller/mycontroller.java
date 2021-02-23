package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import vo.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Controller创建处理器对象，对象放在springmvc容器中
 */
@Controller
public class mycontroller {//后端控制器

    /**
     * 处理器方法返回String  表示逻辑视图名称，需要配置视图解析器
     */
    @RequestMapping(value = "/return_String_view.do")
    public String doReturnView(HttpServletRequest request, String name, Integer age){
        //可以手动添加数据到request作用域
        request.setAttribute("my_name",name);
        request.setAttribute("my_age",age);
       //show 逻辑视图名称，项目中配置了视图解析器
       return "show";
       //框架对视图执行forward转发操作
    }

    //处理器方法返回String，表示完整视图路径，此时不能配置视图解析器
    @RequestMapping(value = "/return_String_view2.do")
    public String doReturnView2(HttpServletRequest request, String name, Integer age){
        //可以手动添加数据到request作用域
        request.setAttribute("my_name",name);
        request.setAttribute("my_age",age);
        //完整视图路径，项目中不能配置视图解析器
        return "/WEB-INF/view/show.jsp";//若要使用完整路径，需将springmvc.xml中的视图解析器关闭
        //框架对视图执行forward转发操作
    }

    //处理器方法返回void,响应ajax请求
    @RequestMapping(value = "/returnVoid_ajax.do")
    public void doReturnVoid(HttpServletResponse response, String name, Integer age) throws IOException {
        //处理ajax，使用json做数据格式
        //service调用完成，使用Student表示处理结果
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        //将结果对象转为json格式的数据
        String json = "";
        if(student != null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("student转换为json==="+json);
        }
        //输出数据，响应ajax请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

    /**
     * 处理器方法返回一个student，通过框架转为json，响应ajax请求
     *
     * @ResponseBody
     *      作用：将处理器方法返回对象转为json后，通过HttpServletResponse输出给浏览器
     *
     * 返回对象框架处理过程
     *      1、框架会把返回的String类型，调用框架中的ArrayList<HttpMessageConverter>中每个类的
     *          canWrite()方法，检查HttpMessageConverter接口的实现类处理student类型的数据
     *      2、框架会调用实现类的write()，MappingJackson2HttpMessageConverter的write方法，将
     *          student对象转为json，调用jackson的ObjectMapper实现转为json
     *      3、框架会调用@ResponseBody将2的结果数据输出到浏览器，ajax的请求处理完成
     *
     */
    @RequestMapping(value = "/requestStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(String name, Integer age){
        //调用service，获取请求处理结果，Student对象表示处理结果
        Student student = new Student();
        student.setName("abc");
        student.setAge(22);
        return student;
    }

    /**
     *处理器方法返回List<Student>
     * @return
     */
    @RequestMapping(value = "/requestStudentJsonArray.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(String name, Integer age){
        List<Student> list = new ArrayList<>();
        //调用service，获取请求处理结果，Student对象表示处理结果
        Student student = new Student();
        student.setName("abc");
        student.setAge(22);
        list.add(student);

        student = new Student();
        student.setName("ABCD");
        student.setAge(27);
        list.add(student);

        return list;
    }

    /**
     * 处理器方法返回String  表示数据，不是视图
     *  区分返回的string时数据还是视图，看有没有 @ResponseBody注解
     *      若有@ResponseBody，则返回的string为数据，反之为视图
     */
    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name,Integer age){
        return "返回数据";
    }

}
