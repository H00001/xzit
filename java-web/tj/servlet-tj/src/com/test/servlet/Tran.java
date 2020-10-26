package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tran1.jsp")
public class Tran extends HttpServlet {
    static int a = 0;
    int b = 0;
    public int add(int x,int y){
        return x+y;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        b ++;
        a ++;
        resp.getWriter().println(add(a,b)+"servlet");
    }
}
