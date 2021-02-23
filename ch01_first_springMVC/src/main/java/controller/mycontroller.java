package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller创建处理器对象，对象放在springmvc容器中
 */
@Controller
public class mycontroller {//后端控制器
    //处理用户提交的请求，springmvc中是使用方法来处理的
    //方法是自定义的，有多种返回值，多种参数，方法名称自定义

    /**
     * 使用dosome方法执行some.do请求
     * @RequestMapping请求映射，将一个请求地址和一个方法绑定在一起
     *          一个请求指定一个方法处理
     *      属性：1、value是一个string，表示请求的url地址（some.do）
     *              value值必须唯一，不能重复   使用时推荐地址以"/"
     *      位置：
     *          1、在方法上（常用）
     *          2、在类上
*          说明：使用RequestMapping修饰的方法叫做处理器方法或控制器方法
     *              其可以处理请求，类似于servlet中的doPost、doGet
     *
     * 返回值 ModelAndView  表示本次处理的结果
     *     Model：数据，请求处理完成后，展示给用户的数据
     *     View：视图，如jsp等
     *
     */
    @RequestMapping(value = "/some.do")//doGet()---service请求处理
    public ModelAndView dosome(){
        //处理some.do请求，相当于service调用处理完成
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求最后将数据放入request作用域  request.setAttribute()
        mv.addObject("msg","springMVC使用");
        mv.addObject("fun","执行dosome()方法");
        //指定视图,指定视图的完整路径
        //框架对视图执行的forward操作，request.getRequestDispather("/show,jsp").forward(....)
        //mv.setViewName("/show.jsp");

        //mv.setViewName("/WEB-INF/view/other.jsp");
        //配置视图解析器后，可以使用逻辑名称（文件名），指定视图
        //框架会使用视图解析器的前缀+逻辑名称+后缀 组成完全路径
        mv.setViewName("other");

        return mv;
    }

}
