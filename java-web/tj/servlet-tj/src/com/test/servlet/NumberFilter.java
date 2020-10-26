package com.test.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = "*.num")
public class NumberFilter extends HttpFilter {
    // 数字过滤器，过滤<0或>100的数据，
    // 并放入attribute中
    // 通过a=10&a=20&a=30&a=100 //传入多个数字

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest r= (HttpServletRequest) request;
        String[] s = r.getParameterValues("a");
        List<Integer> li = new ArrayList<>();
        for (String val : s){
            int v = Integer.parseInt(val);
            if (v>100||v<0){
                continue;
            }else{
                li.add(v);
            }
        }
        r.setAttribute("nums",li);
        super.doFilter(request, response, chain);
    }
}
