package com.example.servlets;

import com.example.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/jsp-example")
public class JspAwareServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setAddress(List.of("Address1", "Address2"));

        request.setAttribute("employee", user);
        request.setAttribute("testKey", "TestValue");
        request.getSession().setAttribute("sessionKey", "session value!!!");

        if ("request".equals(request.getParameter("where"))) {
            request.getRequestDispatcher("get-request-info/123").forward(request, response);
            return;
        }

        request.getRequestDispatcher("static/jsp/jspTest.jsp").forward(request, response);
    }
}
