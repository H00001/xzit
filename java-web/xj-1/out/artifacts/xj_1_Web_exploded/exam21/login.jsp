<%@ page import="java.net.http.HttpRequest" %><%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/9/29
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpServletRequest r = request;
    r.getRequestDispatcher
            (r.getParameter("user").equals("root")?
                    "success.jsp":"fail.jsp").forward(request,response);
%>