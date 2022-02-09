<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">
        <meta charset="UTF-8" />
        <title>Eredmény</title>
    </head>
    <body>
        <%@include file="/items/_variables.jsp" %>

        <%= request.getAttribute("result") %>
        <br />

        <%@include file="/items/_menu.jsp" %>

        <script>
          function preventBack(){window.history.forward();}
          setTimeout("preventBack()", 0);
          window.onunload=function(){null};
        </script>

    </body>
</html>