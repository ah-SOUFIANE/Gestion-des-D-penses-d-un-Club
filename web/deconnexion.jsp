<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>
