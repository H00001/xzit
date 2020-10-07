<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 检查登录用户是否为root
    if (request.getParameter("user").equals("root")) {
        // 添加 session
        // 相当于给用户信息，用户下次可以拿着这些信息
        // 登录网站，这样不需要重新登录了。
        // response.getWriter() === out

        //response.addCookie(new Cookie("id", "1"));
        session.setMaxInactiveInterval(30);
        request.getSession().setAttribute("id",1);
        //response.addCookie(new Cookie("money", "100"));
        request.getSession().setAttribute("money",100);
    }
%>
