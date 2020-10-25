<%@ page import="com.example.User" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/10/9
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User[] a = {new User(1,"liming"),new User(2,"zhangming")};
    request.setAttribute("us",a);
    request.setAttribute("mapp", Map.of(1,"22",2,"33"));
%>
<%--el表达式,对应的是属性名称 因为属性的key是us --%>
<%--<%=u.id%>--%>
<%--${us.id}--%>
<%--两种方式都是获取属性的--%>
${us[0].id} ${us[0].name}
${us[1].id} ${us[1].name}

<%--这是无效的${requestScope.us.id}--%>
${empty a}
<%--21==23--%>
<%=request.getAttribute("a")==null%>
${mapp[2]}