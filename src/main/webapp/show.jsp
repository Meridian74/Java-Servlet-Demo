<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="UTF-8" />
        <title>Title</title>
    </head>
    <%@ page import = "java.* " %>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <body>
        <%= "A(z) " + request.getParameter("num1") +
            " és " + request.getParameter("num2") +
            " összege: " + request.getParameter("result") %>
    </body>
<html>