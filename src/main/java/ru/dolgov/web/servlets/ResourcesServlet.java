package ru.dolgov.web.servlets;

import org.xml.sax.SAXException;
import ru.dolgov.sax.ReadXmlFileSax;
import ru.dolgov.web.AccountServer.ResourceServerController;
import ru.dolgov.web.AccountServer.ResourceServerControllerMBean;
import resources.TestResource;

import javax.management.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Servlet for work with SaxParser. Name xml file getting from request parameter "path".
 * After parse xml file creating object and getting to they fields with assistance MBean controller
 * @author M. Dolgov
 * 09.01.2017.
 */
public class ResourcesServlet extends HttpServlet{
    public static final String PAGE_URL = "/resources";
    TestResource resource;

    public ResourcesServlet(TestResource resource) {
        this.resource = resource;
    }

    public void doPost(HttpServletRequest request,
                  HttpServletResponse response) throws ServletException, IOException{
        String fileName = request.getParameter("path");
        System.out.println(fileName);

        if (fileName == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Parameter path not found");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try {
            resource = (TestResource) ReadXmlFileSax.ReadXml(fileName);
            ResourceServerControllerMBean resourceServer = new ResourceServerController(resource);
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("Admin:type=ResourceServerController");
            mbs.registerMBean(resourceServer, name);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }catch (MalformedObjectNameException | InstanceAlreadyExistsException |
                MBeanRegistrationException | NotCompliantMBeanException ex){
            ex.printStackTrace();
        }
        if (resource != null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(resource.toString());
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Error load resource");
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
    }
}
