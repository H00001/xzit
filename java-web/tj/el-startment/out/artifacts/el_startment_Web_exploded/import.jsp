<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/10/25
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="2.jsp"/>

<%
    request.setAttribute("date",new Date());
%>
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>

<c:set var="name1" value="jony"></c:set>
${name1}
<c:remove var="name1"></c:remove>
${name1}