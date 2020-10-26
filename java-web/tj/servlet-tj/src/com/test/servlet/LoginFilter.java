package com.test.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 注解的方式来配置过滤的匹配
@WebFilter(urlPatterns = "hello*")
public class LoginFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (((HttpServletRequest)request).getSession()
                .getAttribute("login")!=null) {
            //执行下一个过滤器
            super.doFilter(request, response, chain);
        } else{
            ((HttpServletResponse)response).sendRedirect("login");
        }
    }
}
