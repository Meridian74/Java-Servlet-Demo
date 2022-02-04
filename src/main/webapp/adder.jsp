<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="UTF-8" />
        <title>Title</title>
    </head>
    <%@ page import = "java.* " %>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <body>
        <%! int sum; int num1; int num2; %>
        <%
            request.setCharacterEncoding("UTF-8");
            if (request.getParameter("firstNum") != null &&
                    request.getParameter("firstNum") != "") {
                num1 = Integer.parseInt(request.getParameter("firstNum"));
            }
            if (request.getParameter("secondNum") != null &&
                    request.getParameter("secondNum") != "") {
                num2 = Integer.parseInt(request.getParameter("secondNum"));
            }
            sum = num1 + num2;
            out.println("A(z) " + num1 + " és " + num2 + " összege: " + sum);
        %>
    </body>
</html>
