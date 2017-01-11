package ru.dolgov.web.servlets;

import ru.dolgov.web.resources.TestResources;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * BigComp
 * 09.01.2017.
 */
public class ResourcesServlet extends HttpServlet{
    public static final String PAGE_URL = "/resources";
    TestResources resource;

    public ResourcesServlet(TestResources resource) {
        this.resource = resource;
    }

    public void doPost(HttpServletRequest request,
                  HttpServletResponse response) throws ServletException, IOException{
        String fileName = request.getParameter("path");

        if (fileName == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Login/password is empty");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }


    }
}
