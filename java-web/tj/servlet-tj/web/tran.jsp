<%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/10/6
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    static int a = 0;
    int b = 0;
    public int add(int x,int y){
        return x+y;
    }
%>
<%
    b ++;
    a ++;
    out.println(add(a,b)+"jsp");
%>