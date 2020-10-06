<%@ page import="javax.print.DocFlavor" %><%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/9/29
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(request.getSession().getAttribute("id")!=null){
        out.println("login succeed");
    }
%>
<%=request.getSession().getId()%>