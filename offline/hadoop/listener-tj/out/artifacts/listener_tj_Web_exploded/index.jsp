<%@ page import="com.example.User" %>
<%@ page import="com.example.SessionListener" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.getSession().setAttribute("hello",new User());
    out.println(request.getSession().getAttribute("hello"));
    pageContext.getServletContext().setAttribute("key","value");
    pageContext.getServletContext().removeAttribute("key");
    session.setAttribute("SessionListener",new SessionListener());
%>
