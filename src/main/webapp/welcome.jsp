<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">
        <meta charset="UTF-8" />
        <title>Welcome oldal</title>
    </head>
    <body>
        <%@include file="/items/_variables.jsp" %>

        <c:choose>
            <c:when test="${!empty name}" >
                Üdvözöllek <c:out value="${name}" />!
            </c:when>
            <c:otherwise>
                Üdvözöllek Kedves Vendég!
            </c:otherwise>
        </c:choose>

        <br /><br />Válassz az alábbiak közül!<br />
        <%@include file="/items/_menu.jsp" %>

        <script>
          function preventBack(){window.history.forward();}
          setTimeout("preventBack()", 0);
          window.onunload=function(){null};
        </script>

    </body>
</html>