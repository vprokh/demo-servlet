package com.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(value = "/get-request-info/*")
public class RequestInfoServlet extends HttpServlet {

    private final Map<Integer, String> data = new ConcurrentHashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(0);

    @Override
    public void init() throws ServletException {
        System.out.println("INIT Servlet");
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cookie cookie1 = new Cookie("my-cookie", "my-value");
        cookie1.setMaxAge(30);
        response.addCookie(cookie1);

        HttpSession session = request.getSession();
        session.getLastAccessedTime();

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Request Information</title></head>");
        out.println("<body>");

        out.println("<h2>Path Variables:</h2>");
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            String[] pathSegments = pathInfo.split("/");
            for (int i = 1; i < pathSegments.length; i += 2) {
                String pathVarName = pathSegments[i];
                String pathVarValue = (i + 1 < pathSegments.length) ? pathSegments[i + 1] : "";
                out.println("<p>" + pathVarName + " = " + pathVarValue + "</p>");
            }
        } else {
            out.println("<p>No path variables found.</p>");
        }

        out.println("<h2>Request Parameters:</h2>");
        out.println("<ul>");
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = request.getParameter(paramName);
            out.println("<li>" + paramName + " = " + paramValue + "</li>");
        }
        out.println("</ul>");

        out.println("<h2>Cookies:</h2>");
        out.println("<ul>");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println("<li>" + cookie.getName() + " = " + cookie.getValue() + "</li>");
            }
        } else {
            out.println("<li>No cookies found.</li>");
        }
        out.println("</ul>");

        out.println("<h2>Request Headers:</h2>");
        out.println("<ul>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<li>" + headerName + " = " + headerValue + "</li>");
        }
        out.println("</ul>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    @Override
    public void destroy() {
        System.out.println("Destroy Servlet");
        super.destroy();
    }
}
