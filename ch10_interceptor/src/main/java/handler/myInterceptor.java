package handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器类，拦截用户请求
public class myInterceptor implements HandlerInterceptor {

    private long btime = 0;

    /**
     * preHandle预处理方法
     *  参数：
     *    Object handler  被拦截的控制器对象
     *  返回值boolean
     *  特点：
     *      1、方法在控制器方法（myCOntroller的dosome）之前执行
     *          用户请求首先到达此方法
     *      2、在这个方法中可以获取请求的信息，验证请求是否符合要求
     *          若验证失败，则截断请求，请求不能被处理
     *          若验证成功，则放行请求，才能执行控制器方法
     */
    //重要，程序入口
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        btime = System.currentTimeMillis();
        System.out.println("myInterceptor拦截器的preHandle()");
        return true;
        //request.getRequestDispatcher("/tips.jsp").forward(request,response);
        //return false;
    }

    /**
     * postHandle后处理方法
     * 参数：
     *   Object handler 被拦截的处理器对象myController
     *   ModelAndView 处理器方法的返回值
     *
     * 特点：
     *   在处理器方法之后执行（myController.dosome()）
     *   能偶获取到处理器方法的返回值ModelAndView 可以修改ModelAndView中的数据和视图
     *      可以影响最后的执行结果
     *   主要是对原来执行的结果做二次修正
     *
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("myInterceptor拦截器的postHandle()");
        //对dosome执行结果进行调整
        if(modelAndView != null){
            modelAndView.addObject("mydate",new Date());
            modelAndView.setViewName("other");
        }
    }

    /**
     * afterCompletion最后执行的方法
     * 参数：
     *  Object handler 被拦截的处理器对象
     *  Exception ex 程序中的异常
     * 特点
     *  1、在请求处理完成后执行。框架中规定当时图处理完成后，对视图执行forward。就认为请求处理完成。
     *  2、一般做资源回收工作，程序请求中创建了一些对象，在这可删除，回收空间
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("myInterceptor拦截器的afterCompletion()");
        long etime = System.currentTimeMillis();
        System.out.println("请求处理耗时："+ (etime-btime));
    }
}
