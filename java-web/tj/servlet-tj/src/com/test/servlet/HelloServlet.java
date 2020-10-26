package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 1.第一种方式创建Servlet
// 继承HttpServlet，重写 doGet方法
// HttpServlet帮助我们根据不同http方法执行不同的函数。
@WebServlet("/index.jsp")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("service\n");
    }
}
