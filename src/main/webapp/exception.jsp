<%@ page isErrorPage='true' %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
    out.print("Error Message : ");
    out.print(exception.getMessage());
%>