package hu.guidance.servletdemo.service;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

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

        if (session == null) {
            this.context.log("Nem engedélyezett kérés!");
            response.sendRedirect(request.getContextPath() + "/add/welcome");
        } else {
            chain.doFilter(request, response);
        }

    }

}