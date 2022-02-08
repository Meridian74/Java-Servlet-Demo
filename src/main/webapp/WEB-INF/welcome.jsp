<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="UTF-8" />
        <title>Welcome oldal</title>
    </head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <body>
        <c:set var="user" value='<%= request.getSession().getAttribute("user") %>' />
        <c:set var="contextPath" value="<%= request.getContextPath() %>" />

        Üdvözöllek <c:out value="${user.getUsername()}" />!
        <br />
        Válassz az alábbiak közül!
        <br />

        <c:choose>
            <c:when test="${empty user}">
                <a href="${contextPath}/login">Belépés</a> |
            </c:when>
            <c:otherwise>
                <a href="${contextPath}/logout">Kilépés</a> |
            </c:otherwise>
        </c:choose>
        <a href="${contextPath}/demo">Mennyi az idő</a> |
        <a href="${contextPath}/adder">Összeadás</a>
        <br />

    </body>
</html>