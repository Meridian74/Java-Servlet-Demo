<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<c:set var="session" value="<%= request.getSession(false) %>" />
<c:set var="contextPath" value="<%= request.getContextPath() %>" />
<c:set var="user" value='<%= request.getSession().getAttribute("user") %>' />