<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">
        <meta charset="UTF-8" />
        <title>Számbekérő</title>
    </head>
    <body>
        <%@include file="/items/_variables.jsp" %>

        <form method="post" action="${contextPath}/app/adder">
            <fieldset>
                <legend>Két szám összedaása</legend>
                <label for="firstNum">Első szám: </label>
                <input type="number" id="firstNum" name="firstNum" /><br />
                <label for="secondNum">Második szám: </label>
                <input type="number" id="secondNum" name="secondNum" /><br />
                <input type="submit" value="Submit" />
            </fieldset>
        </form>

        <%@include file="/items/_menu.jsp" %>

        <script>
          function preventBack(){window.history.forward();}
          setTimeout("preventBack()", 0);
          window.onunload=function(){null};
        </script>

    </body>
</html>
