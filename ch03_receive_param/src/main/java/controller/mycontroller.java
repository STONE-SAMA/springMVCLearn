package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vo.Student;

/**
 * @Controller创建处理器对象，对象放在springmvc容器中
 */
@Controller
public class mycontroller {//后端控制器

    /**
     * 逐个接收请求参数
     *      要求：处理方法的形参名和请求中参数名必须一致
     *          同名的请求参数赋值给同名的形参
     * 框架接受请求参数
     *      1、使用request对象接受请求参数
     *          String strname = request.getParameter("name")
     *          String strage = request.getParameter("age")
     *      2、springMVC框架通过DispatherServlet（中央调度器）调用MyController的doSome方法
     *          调用方法时，按名称对应，把接收的参数赋值给形参
     *          dosome(strname,Integer.valueOf(strage))
     *          框架会自动提供类型转换功能
     */

    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView dosome(String name, Integer age){
        //处理some.do请求，相当于service调用处理完成
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求最后将数据放入request作用域  request.setAttribute()
        mv.addObject("my_name",name);
        mv.addObject("my_age",age);

        mv.setViewName("show");

        return mv;
    }

    /**
     * 请求参数名与处理器方法的形参名不同
     * @RequestParam  解决请求中参数名与形参名不同的问题
     *      属性：1、value请求中的参数名
     *           2、required是boolean，默认为true
     *                  true表示请求中必须包含此参数
     *      位置：在处理器方法的形参定义前面
     */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView receiveParam(@RequestParam(value = "rname",required = false) String name,
                                     @RequestParam(value = "rage",required = false) Integer age){
        //处理some.do请求，相当于service调用处理完成
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求最后将数据放入request作用域  request.setAttribute()
        mv.addObject("my_name",name);
        mv.addObject("my_age",age);

        mv.setViewName("show");

        return mv;
    }

    /**
     * 处理器方法的形参是java对象，对象的请求名与请求中参数名相同
     * 框架根据创建形参的java对象，给属性赋值。
     *      如请求中参数是name，框架会调用setName()
     * @return
     */
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView receiveParam(Student myStudent){
        //处理some.do请求，相当于service调用处理完成
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求最后将数据放入request作用域  request.setAttribute()
        mv.addObject("my_name",myStudent.getName());
        mv.addObject("my_age",myStudent.getAge());

        mv.setViewName("show");

        return mv;
    }

}
