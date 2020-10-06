<%@ page import="com.example.service.GetClassAndAccountService" %>
<%@ page import="com.example.service.impl.GetClassAndAccountImpl" %>
<%@ page import="com.mysql.jdbc.ConnectionGroupManager" %>
<%@ page import="com.example.pool.MysqlConnectionPool" %><%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/10/7
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MysqlConnectionPool p = new MysqlConnectionPool(8);
    GetClassAndAccountService s = new GetClassAndAccountImpl();
    s.get(out);
%>
