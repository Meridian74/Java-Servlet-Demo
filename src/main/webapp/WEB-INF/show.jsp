<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="UTF-8" />
        <title>Title</title>
    </head>
    <body>
        <%@ page import = "java.* " %>
        <%@ page contentType="text/html; charset=UTF-8" %>

        <%= request.getAttribute("result") %>

        <form method="get" action="<%= request.getContextPath() %>/adder">
            <input type="submit" value="Ismét">
        </form>
        <form method="get" action="index.jsp">
            <input type="submit" value="Kezdő oldal">
        </form>

    </body>
<html>