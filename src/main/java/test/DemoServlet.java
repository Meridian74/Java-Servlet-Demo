package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name = "DemoServlet", urlPatterns = "/hello")
public class DemoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // Set the response message's MIME type
        response.setContentType("text/html;charset=UTF-8");

        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();

        // Write the response message, in an HTML page
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>Test Servlet</title></head>");
            out.println("<body>");
            out.println("<h1>Hello, world!</h1>");  // says Hello
            // Echo client's request information
            out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
            out.println("<p>Protocol: " + request.getProtocol() + "</p>");
            out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
            out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");

            // Echo current time of server
            out.println("<p>Local time of server: <strong>" + LocalDateTime.now() + "</strong></p>");

            // end of HTML content
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();  // Always close the output writer
        }
    }
}
