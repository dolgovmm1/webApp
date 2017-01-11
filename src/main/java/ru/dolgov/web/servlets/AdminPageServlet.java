package ru.dolgov.web.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.dolgov.web.AccountServer.AccountServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * BigComp
 * 07.01.2017.
 */
public class AdminPageServlet extends HttpServlet {
    static final Logger log = LogManager.getLogger(AdminPageServlet.class.getName());
    public static final String PAGE_URL = "/admin";
    private final AccountServer accountServer;

    public AdminPageServlet(AccountServer accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println(accountServer.getUserLimit());

//        String remove = request.getParameter("remove");
//        if (remove != null){
//            accountServer.removeUser();
//            response.getWriter().println("Hasta la vista");
//            response.setStatus(HttpServletResponse.SC_OK);
//            return;
//        }
//
//        int limit = accountServer.getUserLimit();
//        int count = accountServer.getUsersCount();
//        log.debug("Limit: {}, Count: {}", limit, count);
//
//        if (limit > count){
//            log.debug("User pass");
//            accountServer.addNewUser();
//            response.getWriter().println("Hello user");
//            response.setStatus(HttpServletResponse.SC_OK);
//        }else{
//            log.debug("User were rejected");
//            response.getWriter().println("Server is closed");
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        }
    }
}
