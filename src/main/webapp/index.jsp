<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="UTF-8" />
        <title>Welcome oldal</title>
    </head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <body>
        Üdvözöllek!
        <br />
        Válassz az alábbiak közül!
        <br />
        <br />
        <a href= <%= request.getContextPath() %>/login.jsp>Bejelentkezés</a> |
        <a href= <%= request.getContextPath() %>/demo>Mennyi az idő</a> |
        <a href="<%= request.getContextPath() %>/adder">Összeadás</a><br />
    </body>
</html>
