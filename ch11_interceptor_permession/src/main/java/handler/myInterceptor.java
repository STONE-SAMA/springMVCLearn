package handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器类，拦截用户请求
public class myInterceptor implements HandlerInterceptor {

    //验证登录的用户信息
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("myInterceptor拦截器的preHandle()");
        String loginName = "";
        //从session中获取name的值
        Object attr = request.getSession().getAttribute("name");
        if(attr != null){
          loginName = (String) attr;
        }
        //判断登录用户账户
        if(!loginName.equals("abc")){
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }
        return true;

    }

}
