<%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/10/5
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String attrid ="login:"+session.getAttribute("username");
    Object times = application.getAttribute(attrid);
    application.setAttribute(attrid, times!=null? (Integer)times+1:1);
%>
<%="user:"+attrid%>
<%="times:"+times%>