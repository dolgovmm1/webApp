package ru.dolgov.web.servlets;

import ru.dolgov.web.dbService.DbException;
import ru.dolgov.web.dbService.DbService;
import ru.dolgov.web.dbService.DbServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Dolgov
 * 02.01.2017.
 */
public class SignUpServlet extends HttpServlet {
    private DbService dbService;
    public static final String PAGE_URL = "/signup";

    public SignUpServlet(DbService dbService) {
        this.dbService = dbService;
    }

    //sign up
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (login != null || pass != null) {
            try {
                if (dbService.getUserByLogin(login) == null) {
                    dbService.addUser(login, pass);
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().println(login + " added.");
                    response.setStatus(HttpServletResponse.SC_OK);
                    return;
                }
            } catch (DbException ex) {
                System.out.println("Error get user by login " + ex.getMessage());
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("this login already exist");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;

        }
    }
}
