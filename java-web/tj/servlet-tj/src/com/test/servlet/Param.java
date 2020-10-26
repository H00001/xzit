package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// 验证servlet的参数
@WebServlet("/param.serv")
public class Param extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("a");
        System.out.println(s);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
