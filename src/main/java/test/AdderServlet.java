package test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdderServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        User user = (User) request.getSession().getAttribute("user");
        RequestDispatcher rd;
        if (user != null) {
            rd = getServletContext().getRequestDispatcher("/WEB-INF/get-two-numbers.jsp");
        } else {
            rd = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
        }
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String num1 = request.getParameter("firstNum");
        String num2 = request.getParameter("secondNum");
        String result;

        if (num1 != null && !num1.equals("") && num2 != null && !num2.equals("")) {
            int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
            result = "A(z) " + num1 + " és " + num2 + " összege: " + sum;
        } else {
            result = "Hibás adat(ok)!";
        }

        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/show.jsp");
        rd.forward(request, response);
    }
}
