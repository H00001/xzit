<%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/10/6
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int l = Integer.parseInt(request.getParameter("limit"));
    int p = Integer.parseInt(request.getParameter("page"));
    request.getRequestDispatcher("index.jsp?limit="+l+"&offset="+(l*(p-1))).forward(request,response);
%>
