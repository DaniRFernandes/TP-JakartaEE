package com.example.jakartaee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "checkerServlet", value = "/checker-servlet")
public class CheckerServlet extends HttpServlet {
    private static String fileDestination;
    private static int max_length;

    public void init() {
        fileDestination = "checker.jsp";
        max_length = 10;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        int rows;
        int columns;

        if (request.getParameter("rows") != null && request.getParameter("columns") != null) {
            rows = Integer.parseInt(request.getParameter("rows"));
            columns = Integer.parseInt(request.getParameter("columns"));

            if (checkLength(rows) && checkLength(columns)) {
                request.setAttribute("rows", rows);
                request.setAttribute("columns", columns);
            }
        }

        RequestDispatcher disp = request.getRequestDispatcher(fileDestination);
        try {
            disp.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect(fileDestination);
    }

    public static boolean checkLength(int length) {
        return 0 <= length && length <= max_length;
    }
}
