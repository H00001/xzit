<<%@ page import="com.example.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ibf
  Date: 2020/10/7
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<User> u = new ArrayList<>();
    u.add(new User(1,"liming"));
    u.add(new User(2,"zhangsan"));
    u.add(new User(3,"zhang4"));
    u.add(new User(1,"liming"));
    u.add(new User(2,"zhangsan"));
    u.add(new User(3,"zhang4"));
    request.setAttribute("use",new User(3,"zhang4"));
%>
${use.id}
<html>
<table border="1">
    <%
        for (User user : u) {
             out.print("<tr><td>"+user.id+"</td> <td>"+user.name+"</td></tr>");
         }
    %>
</table>

</html>