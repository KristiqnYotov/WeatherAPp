package com.example.demo2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetTimeServlet", urlPatterns = "/gettimeservlet")
public class GetTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Parameter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int number = Integer.parseInt(request.getParameter("timer"));
        WeatherApp app = new WeatherApp();
        app.run(number);
        getServletContext().getRequestDispatcher("/Parameter.jsp").forward(request, response);

    }
}
