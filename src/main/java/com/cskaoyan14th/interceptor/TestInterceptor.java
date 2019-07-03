package com.cskaoyan14th.interceptor;

import com.cskaoyan14th.vo.Admin2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInterceptor implements HandlerInterceptor {
    /*拦截器的preHandle方法可以用来做权限控制*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin2 admin2 = (Admin2) request.getSession().getAttribute("admin2");
        //System.out.println(admin2);
        if (admin2 != null) {
            return true;
        }
        else {
            request.getRequestDispatcher("/").forward(request, response);
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}