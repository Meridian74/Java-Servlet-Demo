<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="UTF-8" />
        <title>Eredmény</title>
    </head>
    <body>
        <%@include file="/WEB-INF/_variables.jsp" %>

        <%= request.getAttribute("result") %>
        <br />

        <%@include file="/WEB-INF/_menu.jsp" %>
    </body>
</html>