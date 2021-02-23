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

    @RequestMapping(value = "/test/some.do")
    public ModelAndView dosome(){
        //处理some.do请求，相当于service调用处理完成
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求最后将数据放入request作用域  request.setAttribute()
        mv.addObject("msg","springMVC使用");
        mv.addObject("fun","执行dosome()方法");
        //指定视图,指定视图的完整路径
        //框架对视图执行的forward操作，request.getRequestDispather("/show,jsp").forward(....)
        mv.setViewName("show");
        return mv;
    }


}
