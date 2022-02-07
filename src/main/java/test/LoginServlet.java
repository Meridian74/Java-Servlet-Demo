package test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
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
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/get-two-numbers.jsp");
                User user = verifiedUser.get();
                request.getSession().setAttribute("user", user);
                rd.forward(request, response);
            } else {
                out.print("Hibás felhasználói név vagy jelszó!");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
                rd.include(request, response);
            }
        }
    }
}
