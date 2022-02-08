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
        try (PrintWriter out=response.getWriter()) {
            HttpSession session=request.getSession();
            session.invalidate();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome");
            rd.include(request, response);
            out.print("You are successfully logged out!");
        }

    }
}
