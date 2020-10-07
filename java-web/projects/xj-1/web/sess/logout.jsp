<%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/9/29
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 让session失效可以注销登录
    session.invalidate();
    // 给 session存储的信息清空
    // session.removeAttribute("id");
%>