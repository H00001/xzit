<%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/9/29
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ServletContext s = application;
    s.setAttribute
            ("times",s.getAttribute("times")==null
                    ?1:((Integer)s.getAttribute("times"))+1);
    out.println(s.getAttribute("times"));
%>