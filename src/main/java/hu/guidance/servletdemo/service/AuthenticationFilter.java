package hu.guidance.servletdemo.service;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) {
        this.context = filterConfig.getServletContext();
        this.context.log("AuthenticationFilter inicializálva!");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        if (session == null) {
            this.context.log("Nem engedélyezett kérés!");
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/welcome.jsp");
            rd.forward(request, response);
        } else {
            chain.doFilter(request, response);
        }

    }

}