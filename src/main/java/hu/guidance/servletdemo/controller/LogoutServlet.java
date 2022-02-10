package hu.guidance.servletdemo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false);

            if (session != null) {
                session.removeAttribute("userId");
                session.removeAttribute("token");
                session.removeAttribute("username");
                session.invalidate();
            }

            out.println("Sikeresen kijelentkeztél!");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.include(request, response);

        }

    }
}
