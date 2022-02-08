<%@ page import = "java.* " %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="UTF-8" />
        <title>Eredmény</title>
    </head>
    <body>
        <%= request.getAttribute("result") %>

        <form method="get" action="<%= request.getContextPath() %>/adder">
            <input type="submit" value="Ismét">
        </form>
        <form method="get" action="<%= request.getContextPath() %>/welcome">
            <input type="submit" value="Kezdő oldal">
        </form>
        <form method="get" action="<%= request.getContextPath() %>/logout">
            <input type="submit" value="Kilépés">
        </form>
    </body>
</html>