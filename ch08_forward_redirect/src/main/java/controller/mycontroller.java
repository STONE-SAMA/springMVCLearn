package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller创建处理器对象，对象放在springmvc容器中
 *
 * @RequestMapping
 *      value 所有请求地址的公共部分，叫做模块名称
 *      位置 类上方
 *
 */
@Controller
public class mycontroller {//后端控制器

    /**
     * 处理器方法返回ModelAndView，实现转发forward
     *  语法：setViewName("forward：试图文件完整路径")
     *  forward特点：不和视图解析器一同使用
     */
    @RequestMapping(value = "doForward.do")
    public ModelAndView dosome(){
        //处理some.do请求，相当于service调用处理完成
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求最后将数据放入request作用域  request.setAttribute()
        mv.addObject("msg","springMVC使用");
        mv.addObject("fun","执行dosome()方法");
        //指定视图,指定视图的完整路径
        //框架对视图执行的forward操作，request.getRequestDispather("/show,jsp").forward(....)
        //mv.setViewName("show");
        //显式转发
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;
    }
    /**
     * 处理器方法返回ModelAndView，实现转发redirect
     * 语法：setViewName("redirect：试图文件完整路径")
     * redirect特点：不和视图解析器一同使用
     *
     * 框架对重定向的操作
     *      1、框架将model中的简单类型的数据，转为string类型使用，作为hello.jsp的get请求参数使用
     *          目的是在diRedirect.do与hello.jsp之间传递数据
     *      2、在目标界面可以使用参数集合对象${param}来获取请求参数的值
     *          ${param.msg}
     *      3、重定向不能访问/WEB-INF资源
     */
    @RequestMapping(value = "doRedirect.do")
    public ModelAndView doredirect(){
        //处理some.do请求，相当于service调用处理完成
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求最后将数据放入request作用域  request.setAttribute()
        mv.addObject("msg","springMVC使用");
        mv.addObject("fun","执行dosome()方法");
        //指定视图,指定视图的完整路径
        //框架对视图执行的forward操作，request.getRequestDispather("/show,jsp").forward(....)
        //重定向

        mv.setViewName("redirect:/hello.jsp");
        return mv;
    }

}
