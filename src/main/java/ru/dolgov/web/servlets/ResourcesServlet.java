package ru.dolgov.web.servlets;

import ru.dolgov.web.resources.TestResources;

import javax.servlet.http.HttpServlet;

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


}
