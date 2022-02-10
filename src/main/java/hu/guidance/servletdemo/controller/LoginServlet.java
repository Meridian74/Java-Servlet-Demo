package hu.guidance.servletdemo.controller;

import hu.guidance.servletdemo.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import hu.guidance.servletdemo.model.LoginDao;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.Random;

public class LoginServlet extends HttpServlet {
    private Random randomNumber;

    @Override
    public void init(ServletConfig config) {
        randomNumber = new Random();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

        String path = request.getContextPath();
        response.sendRedirect(path + "/login.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        Optional<User> verifiedUser = LoginDao.validate(name, password);
        if (verifiedUser.isPresent()) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate(); // old session eliminated
            }

            User user = verifiedUser.get();
            int token = randomNumber.nextInt(Integer.MAX_VALUE);
            user.setToken(token);

            session = request.getSession(true); // generate a new session
            session.setAttribute("userId", user.getId());
            session.setAttribute("token", user.getToken());
            session.setAttribute("name", user.getName());

            String path = request.getContextPath();
            response.sendRedirect(path + "/app/adder");

        } else {
            try (PrintWriter out = response.getWriter()) {
                out.print("<font color=red>Hibás felhasználói név vagy jelszó!</font>");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.include(request, response);
            }
        }
    }
}

