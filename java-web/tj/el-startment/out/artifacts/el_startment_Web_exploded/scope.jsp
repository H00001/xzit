<%@ page import="com.example.User" %><%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/10/9
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.setAttribute("aaa",123);
    pageContext.setAttribute("bbb","456");
    request.setAttribute("u",new User[]{new User(10,"liming"),
            new User(11,"zhanging"),
        new User(12,"zhaoming")});
%>
${requestScope.u[0].id} ${requestScope.u[0].name}<%="<br>"%>
${requestScope.u[1].id} ${requestScope.u[1].name}<%="<br>"%>
${requestScope.u[2].id} ${requestScope.u[2].name}<%="<br>"%>
${sessionScope.aaa}
<%--代码一样的--%>
<%--如果对象前面加上域的名称，那么就会从域中搜寻--%>
<%=session.getAttribute("aaa")%>
${pageScope.bbb}
<%--如果什么也不加，只写对象名，就会从所有域中搜寻--%>
<%
    request.setAttribute("abc","777");
    session.setAttribute("abc","8888");
    pageContext.setAttribute("abc","999");
    application.setAttribute("abc","aaa");
    // 优先级 pageContext > request > session > application
%>
${requestScope.abc}
${sessionScope.abc}
${pageScope.abc}
${applicationScope.abc}
${abc}