package test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String link;
        if (request.getSession().getAttribute("user") == null) {
            link = "/login>Bejelentkezés";
        }
        else {
            link = "/logout>Kilépés";
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/welcome.jsp");
        request.setAttribute("link-switch", link);
        rd.forward(request, response);

    }
}
