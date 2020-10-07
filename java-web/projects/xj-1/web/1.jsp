<%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/9/29
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 转发的新页面
    // request和response 是传入的 `工作资料` 交接工作
    // 进行控制权转交给新页面，所有request和response也要携带
    request.getRequestDispatcher("2.jsp").forward(request,response);
%>

<%=1%>
