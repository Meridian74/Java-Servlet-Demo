<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8" />
    <title>Login</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/login" method="post">
    <fieldset>
        <legend>Log in:</legend>
            Felhasználói név:<input type="text" name="username"/><br/>
            Jelszó:<input type="password" name="password"/><br/><br/>
            <input type="submit" value="Elküld"/>
            <input type="reset" value="Töröl"/>
        </form>
    </fieldset>
</form>
</body>
</html>
