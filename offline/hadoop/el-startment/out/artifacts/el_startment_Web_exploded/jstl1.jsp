<%@ page import="com.example.User" %><%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/10/25
  Time: 8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="name" value="helen" scope="application"/>
<%
    // 这两种是等价的
    //application.setAttribute("name","helen");
    out.println(application.getAttribute("name"));
    application.setAttribute("user",new User());
%>

<c:set target="${user}" property="name" value="123"/>
${user.name}
<%
    //19==23
    ((User) application.getAttribute("user")).setName("123");
%>
<%--使用cout来显示变量的值--%>
<c:out value="i am cout"/>
<c:out value="${user.name}"/>