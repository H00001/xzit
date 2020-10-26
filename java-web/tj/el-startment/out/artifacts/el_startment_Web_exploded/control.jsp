<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/10/25
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${1==1}" scope="request" var="res">
    <c:out value="if(1==1){out.print('1==1');}"></c:out>
</c:if>
<%
    // 16 == 11
        request.setAttribute("res",1==1);
%>
<%=request.getAttribute("res")%>
<%
    List<User> us = new ArrayList<>();
    us.add(new User(1,"liming"));
    us.add(new User(2,"zhangsan"));
    for (User u : us) {  //25-27 == 30-32
        out.println(u.name);
    }
    request.setAttribute("us",us);
%>
<c:forEach items="${us}" var="u">
    <c:out value="${u.name}"></c:out>
</c:forEach>