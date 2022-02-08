<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="UTF-8" />
        <title>Számbekérő</title>
    </head>
    <body>
        <form method="post" action="<%= request.getContextPath() %>/adder">
            <fieldset>
                <legend>Két szám összedaása</legend>
                <label for="firstNum">Első szám: </label>
                <input type="number" id="firstNum" name="firstNum" /><br />
                <label for="secondNum">Második szám: </label>
                <input type="number" id="secondNum" name="secondNum" /><br />
                <input type="submit" value="Submit" />
            </fieldset>
        </form>
        <form method="get" action="<%= request.getContextPath() %>/welcome">
            <input type="submit" value="Kezdő oldal" />
        </form>
        <form method="get" action="<%= request.getContextPath() %>/logout">
            <input type="submit" value="Kilépés" />
        </form>
    </body>
</html>
