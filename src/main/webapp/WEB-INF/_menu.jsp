<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<c:set var="session" value="<%= request.getSession(false) %>" />
<c:set var="contextPath" value="<%= request.getContextPath() %>" />
<c:set var="user" value='<%= request.getSession().getAttribute("user") %>' />

<a href="${contextPath}/welcome">Nyitóoldal</a> |
<a href="${contextPath}/app/demo">Mennyi az idő</a> |
<a href="${contextPath}/app/adder">Összeadás</a> |
<c:choose>
    <c:when test="${empty user}">
        <a href="${contextPath}/app/login">Belépés</a> |
    </c:when>
    <c:otherwise>
        <a href="${contextPath}/app/logout">Kilépés</a> |
    </c:otherwise>
</c:choose>
<br />