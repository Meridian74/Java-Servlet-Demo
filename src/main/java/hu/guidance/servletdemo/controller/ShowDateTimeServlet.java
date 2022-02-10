package hu.guidance.servletdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ShowDateTimeServlet extends HttpServlet {

    private LocalDateTime servletStart;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Set the response message's MIME type
        response.setContentType("text/html;charset=UTF-8");

        // Write the response message, in an HTML page
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>Time now!</title></head>");
            out.println("<body>");
            out.println("<h1>Mennyi az idő</h1>");
            out.println("<p>Kérés adatai:</p>");
            out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
            out.println("<p>Protocol: " + request.getProtocol() + "</p>");
            out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
            out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");

            out.println("<br/><p>Most éppen ennyi az idő: <strong>" + LocalDateTime.now() + "</strong></p>");
            out.println("<p>Servlet indítási időpontja: <strong>" + servletStart + "</strong></p>");
            out.println("<form method='get' action='" + request.getContextPath() + "/welcome'>");
            out.println("<input type='submit' value='Kezdő oldal'>");
            out.println("</form>");
            out.println("<form method='get' action='" + request.getContextPath() + "/logout'>");
            out.println("<input type='submit' value='Kilépés'>");
            out.println("</form>");

            // end of HTML content
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "It is a test servlet!";
    }

    @Override
    public void init() {
        servletStart = LocalDateTime.now();
    }
}
