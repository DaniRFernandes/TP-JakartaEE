package com.example.jakartaee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "clientServlet", value = "/client-servlet")
public class ClientServlet extends HttpServlet {
    private static String fileDestination;

    private List<Client> clientList;

    public void init() {
        fileDestination = "client.jsp";
        clientList = new ArrayList<>();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("client-list", clientList);

        RequestDispatcher disp = request.getRequestDispatcher(fileDestination);
        try {
            disp.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect(fileDestination);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String city = request.getParameter("city");
        int code = Integer.parseInt(request.getParameter("code"));

        clientList.add(new Client(name, city, code));

        request.setAttribute("client-list", clientList);

        RequestDispatcher disp = request.getRequestDispatcher(fileDestination);
        try {
            disp.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect(fileDestination);
    }
}
