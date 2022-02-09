package hu.guidance.servletdemo.controller;

import hu.guidance.servletdemo.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import hu.guidance.servletdemo.model.LoginDao;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String name = request.getParameter("username");
            String password = request.getParameter("password");

            Optional<User> verifiedUser = LoginDao.validate(name, password);
            if (verifiedUser.isPresent()) {
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.invalidate(); // old session eliminated
                }

                User user = verifiedUser.get();
                session = request.getSession(true); // generate a new session
                session.setAttribute("user", user);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/app/get-two-numbers.jsp");
                rd.forward(request, response);

            } else {
                out.print("<font color=red>Hibás felhasználói név vagy jelszó!</font>");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                rd.include(request, response);
            }
        }
    }
}
