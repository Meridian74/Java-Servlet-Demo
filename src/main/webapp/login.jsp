<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">
        <meta charset="UTF-8" />
        <title>Login</title>
    </head>
    <body>
        <%@include file="/items/_variables.jsp" %>

        <c:choose>
            <c:when test="${!empty name}" >
                Be vagy már jelentkezve, előbb lépjél ki!
                <br />
            </c:when>
            <c:otherwise>
                <form action="${contextPath}/login" method="post">
                    <fieldset>
                        <legend>Belépés:</legend>
                            Felhasználói név:<input type="text" name="username"/><br/>
                            Jelszó:<input type="password" name="password"/><br/><br/>
                            <input type="submit" value="Elküld"/>
                            <input type="reset" value="Töröl"/>
                    </fieldset>
                </form>
            </c:otherwise>
        </c:choose>

        <%@include file="/items/_menu.jsp" %>

        <script>
          function preventBack(){window.history.forward();}
          setTimeout("preventBack()", 0);
          window.onunload=function(){null};
        </script>

    </body>
</html>
