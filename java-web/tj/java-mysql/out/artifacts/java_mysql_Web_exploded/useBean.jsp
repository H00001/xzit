<%@ page import="com.example.User" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/10/6
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="com.example.User" scope="page"></jsp:useBean>
<%
    // 通过反射动态产生对象
    User user_1 = (User)
       Class.forName("com.example.User").
               getDeclaredConstructor().newInstance();
    // 标准的 静态产生对象
    // com.example.User user_1 = new User();
%>
<jsp:setProperty name="user" property="*"></jsp:setProperty>
<%
    // 通过反射动态的设置参数
    Iterator<String> es = request.getParameterNames().asIterator();
    // 获取所有的参数 es:username,password
    while (es.hasNext()) {
        String n = es.next(); //n:1:username
        // 找到类中对应的叫 username的字段
        Field f = user_1.getClass().getDeclaredField(n);
        f.setAccessible(true);
            // 对user_1对象的username字段设置 request.getParameter(n)
        f.set(user_1, request.getParameter(n));
    }
    // * 代表了所有的属性
    // 静态的设置参数
    // user_1.setUsername(request.getParameter("username"));
    //user_1.setPassword(request.getParameter("password"));
%>
<jsp:getProperty name="user" property="username"/>
<%
    // 打印属性
    out.println("user1:"+user_1.getUsername());
    out.println("user1:"+user_1.getPassword());
%>