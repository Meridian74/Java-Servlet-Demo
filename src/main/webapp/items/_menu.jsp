<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<a href="${contextPath}/welcome">Nyitóoldal</a> |
<a href="${contextPath}/app/demo">Mennyi az idő</a> |
<a href="${contextPath}/app/adder">Összeadás</a> |
<c:choose>
    <c:when test="${empty name}">
        <a href="${contextPath}/login">Belépés</a> |
    </c:when>
    <c:otherwise>
        <a href="${contextPath}/logout">Kilépés</a> |
    </c:otherwise>
</c:choose>
<br />