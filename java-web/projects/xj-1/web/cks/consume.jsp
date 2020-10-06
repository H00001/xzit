
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 检查cookies
    Cookie[] cks = request.getCookies();
    for (Cookie ck : cks) {
        if (ck.getName().equals("id")){
            out.println("login succeed");
        }
    }
%>
