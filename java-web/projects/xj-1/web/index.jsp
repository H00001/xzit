<%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/9/29
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    //a=1&a=2&a=3
    // 仅仅返回这个名称第一个值
    String a =  request.getParameter("a");
    // 返回该名称全部值
    String[] s = request.getParameterValues("a");
    for (String v: s){
        out.println(v);
    }

%>
<%=a%>