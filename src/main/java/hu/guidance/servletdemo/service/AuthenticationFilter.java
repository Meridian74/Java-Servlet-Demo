package hu.guidance.servletdemo.service;

import hu.guidance.servletdemo.model.LoginDao;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

public class AuthenticationFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig fc) {
        this.context = fc.getServletContext();
        this.context.log("AuthenticationFilter inicializálva!");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        Integer sessionToken = (Integer) session.getAttribute("token");
        if (sessionToken != null) {
            long userId = (Long) session.getAttribute("userId");

            Optional<Integer> userToken = LoginDao.getTokenById(userId);
            if (userToken.isPresent() && userToken.get().intValue() == sessionToken.intValue()) {
                chain.doFilter(request, response);
            }
            else {
                this.context.log("Nem érvényes user token!");
                response.sendRedirect(request.getContextPath() + "/add/welcome");
            }
        } else {
            this.context.log("Nem engedélyezett kérés!");
            response.sendRedirect(request.getContextPath() + "/add/welcome");
        }
    }

}