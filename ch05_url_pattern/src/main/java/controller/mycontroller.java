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

    @RequestMapping(value = "/some.do")
    public ModelAndView doReturnView(String name, Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("my_name",name);
        mv.addObject("my_age",age);
        mv.setViewName("show");
        return mv;
       //框架对视图执行forward转发操作
    }

}
