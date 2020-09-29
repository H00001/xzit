<%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/9/29
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 之所以能够拿到是因为 requset是 index.jsp给的，index.jsp已经设置了
    // 所以这里能够取得
    out.println(request.getAttribute("login"));
%>