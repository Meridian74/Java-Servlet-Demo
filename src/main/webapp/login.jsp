<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8" />
    <title>Login</title>
</head>
<body>
    <c:set var="contextPath" value="<%= request.getContextPath() %>" />
    <c:set var="session" value="<%= request.getSession(false) %>" />

    <c:choose>
        <c:when test="${empty session}" >
            Be vagy már jelentkezve, előbb lépjél ki!
        </c:when>
        <c:otherwise>
            <form action="${contextPath}/login" method="post">
                <fieldset>
                    <legend>Log in:</legend>
                        Felhasználói név:<input type="text" name="username"/><br/>
                        Jelszó:<input type="password" name="password"/><br/><br/>
                        <input type="submit" value="Elküld"/>
                        <input type="reset" value="Töröl"/>
                </fieldset>
            </form>
        </c:otherwise>
    </c:choose>

</body>
</html>
