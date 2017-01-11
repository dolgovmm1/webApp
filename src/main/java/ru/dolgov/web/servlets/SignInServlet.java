package ru.dolgov.web.servlets;

import ru.dolgov.web.dbService.DbException;
import ru.dolgov.web.dbService.DbService;
import ru.dolgov.web.dbService.DbServiceImpl;
import ru.dolgov.web.dbService.dataSet.UserDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Dolgov
 * 02.01.2017.
 */
public class SignInServlet extends HttpServlet{
    private final DbService dbService;
    public static final String PAGE_URL = "/signin";

    public SignInServlet(DbService dbService) {
        this.dbService = dbService;
    }

    //sign in
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        if (login == null || pass == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Login/password is empty");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserDataSet user = null;
        try {
            user = dbService.getUserByLogin(login);
        } catch (DbException ex) {
            System.out.println("Error get user by login " + ex.getMessage());
        }
        if (user == null || !user.getPassword().equals(pass)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("This login not registered");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("Authorized: " + login);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
