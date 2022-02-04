<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="UTF-8" />
        <title>Title</title>
    </head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <body>
        Üdvözöllek!
        <br />
        Válassz az alábbiak közül!
        <br />
        <br />

        <a href= <%= request.getContextPath() %>/hello>Mennyi az idő</a> | <a href="<%= request.getContextPath() %>/query-two-numbers.html">Összeadás</a><br />
    </body>
</html>
