<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="UTF-8" />
        <title>Welcome oldal</title>
    </head>
    <body>
        <%@include file="/items/_variables.jsp" %>

        <c:choose>
            <c:when test="${!empty user}" >
                Üdvözöllek <c:out value="${user.getName()}" />!
            </c:when>
            <c:otherwise>
                Üdvözöllek Kedves Vendég!
            </c:otherwise>
        </c:choose>

        <br /><br />Válassz az alábbiak közül!<br />
        <%@include file="/items/_menu.jsp" %>
    </body>
</html>