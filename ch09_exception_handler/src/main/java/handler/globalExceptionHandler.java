package handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import Exception.NameException;
import Exception.AgeException;

/**
 * @ControllerAdvice 控制器增强（给控制器增加异常处理功能）
 * 特点：必须让框架知道这个注解所在的包名，需要在springMVC配置文件声明组件扫描器
 * 指定ControllerAdvice所在包名
 */
@ControllerAdvice
public class globalExceptionHandler {
    //定义方法处理发生的异常
    /**
     * 处理异常方法与控制器方法定义相同
     *
     * 形参Exception，表示controller中抛出的异常对象
     * 通过形参可以获得异常信息
     *
     * @ExceptionHandler 表示异常类型，当发生异常时，有当前方法处理
     *
     */
    //处理姓名异常
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception){
        /**
         * 异常处理逻辑：
         * 1、记录异常
         * 2、发送异常信息
         * 3、给用户友好提示
         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","姓名须为abc！");
        mv.addObject("ex",exception);
        mv.setViewName("nameError");
        return mv;
    }

    //处理年龄异常
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","年龄不能大于35！");
        mv.addObject("ex",exception);
        mv.setViewName("ageError");
        return mv;
    }

    //处理不知名异常
    @ExceptionHandler
    public ModelAndView doOtherException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex",exception);
        mv.setViewName("defaultError");
        return mv;
    }
}
