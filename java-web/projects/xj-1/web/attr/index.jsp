<%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/9/29
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 设置attribute
    request.setAttribute("login","success");
    // 转发
    request.getRequestDispatcher("3.jsp").forward(request,response);
%>