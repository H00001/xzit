<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/10/9
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("a","hello");
    request.setAttribute("b","hello");
    request.setAttribute("left",new Integer(129));
    request.setAttribute("right",new Integer(129));
    List<String> ls = new ArrayList<>();
    ls.add("el ");
    ls.add("statement ");
    request.setAttribute("ls",ls);
%>
${(3+4)*9}
<%=(3+4)*9%>
${1==2}
<%="java:"+(1==2)%>
${true&&false}
${1>2?100:200}
${empty a}
<%="java:"+(request.getAttribute("a")==null)%>
${a eq b}
${left eq right}
${ls[1]}