<%-- 
    Document   : securing
    Created on : 06/04/2021, 03:51:22
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("usuario") == null) response.sendRedirect("./vistas/login.jsp");
%>
