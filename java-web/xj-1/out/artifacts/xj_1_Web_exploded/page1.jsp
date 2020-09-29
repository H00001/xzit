<%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/9/29
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int i = (Integer)request.getSession().getAttribute("id");
    ServletContext s = application;
    s.setAttribute
            ("times:"+i,s.getAttribute("times:"+i)==null
                    ?1:((Integer)s.getAttribute("times:"+i))+1);
    out.println(s.getAttribute("times"+i));
%>