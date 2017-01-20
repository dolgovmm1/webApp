package ru.dolgov.web.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.dolgov.web.AccountServer.*;
import ru.dolgov.web.dbService.DbService;
import ru.dolgov.web.dbService.DbServiceImpl;
import resources.TestResource;
import ru.dolgov.web.servlets.*;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author M. Dolgov
 * 02.01.2017.
 */
public class Main {
    static final Logger log = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        log.debug("Application started");
        DbService dbService = new DbServiceImpl();
        log.debug("DbService initiated");
        dbService.printConnectInfo();
        log.debug("DbService connected");

        AccountServer accountServer = new AccountServerImpl(10);

        AccountServerControllerMBean accountServerController = new AccountServerController(accountServer);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("ServerManager:type=AccountServerController");
        mbs.registerMBean(accountServerController, name);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new Frontend()), Frontend.PAGE_URL);
        context.addServlet(new ServletHolder(new SignUpServlet(dbService)), SignUpServlet.PAGE_URL);
        context.addServlet(new ServletHolder(new SignInServlet(dbService)), SignInServlet.PAGE_URL);
        context.addServlet(new ServletHolder(new AdminPageServlet(accountServer)), AdminPageServlet.PAGE_URL);
        context.addServlet(new ServletHolder(new ResourcesServlet(new TestResource())), ResourcesServlet.PAGE_URL);
        log.debug("Adding servlets into handler");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");
        log.debug("Adding resource handler");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});
        log.debug("Create Handler list");

        Server server = new Server(8080);
        log.debug("Create server jetty on port 8080");
        server.setHandler(handlers);
        log.debug("Adding handler to server jetty");

        server.start();
        log.debug("Starting server jetty");
        System.out.println("Server started");
        server.join();
        log.debug("Server stopped");
    }
}
