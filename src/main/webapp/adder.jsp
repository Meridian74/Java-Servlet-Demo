<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="UTF-8" />
        <title>Title</title>
    </head>

    <%@ page import = "java.* " %>
    <%@ page contentType="text/html; charset=UTF-8" %>

    <body>

        <%@ page errorPage="exception.jsp" %>
        <%
            request.setCharacterEncoding("UTF-8");

            String firstNum = request.getParameter("firstNum");
            if (firstNum != null && !firstNum.equals("")) {
                request.setAttribute("num1", firstNum);
            }

            String secondNum = request.getParameter("secondNum");
            if (secondNum != null && !secondNum.equals("")) {
                request.setAttribute("num2", secondNum);
            }

            int result = Integer.parseInt(firstNum) + Integer.parseInt(secondNum);
            request.setAttribute("result", result);
        %>

        <%-- this code only for trying jsp:include --%>
        <jsp:include page="show.jsp" >
            <jsp:param name="result" value="${result}" />
            <jsp:param name="num1" value="${num1}" />
            <jsp:param name="num2" value="${num2}" />
        </jsp:include>

    </body>
</html>
