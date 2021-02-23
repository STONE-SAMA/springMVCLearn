package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @RequestMapping(value = "/some.do")
    public ModelAndView dosome(String name, Integer age) {
        ModelAndView mv = new ModelAndView();
        System.out.println("执行dosome");
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }


}
