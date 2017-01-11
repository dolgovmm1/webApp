package ru.dolgov.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Dolgov
 * 27.12.2016.
 */
public class Frontend extends HttpServlet{
    public static final String PAGE_URL = "/mirror";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String pageVariables = request.getParameter("key");
        response.getWriter().println(pageVariables);
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
}
