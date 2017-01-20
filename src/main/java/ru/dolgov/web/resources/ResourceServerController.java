package ru.dolgov.web.resources;

import ru.dolgov.web.resources.TestResources;

/**
 * Class implrement getting fields TestResource in MBean jconsole
 * @author M. Dolgov
 * 11.01.2017.
 */
public class ResourceServerController implements ResourceServerControllerMBean {
    private TestResource resource;

    public ResourceServerController(TestResource resource){
        this.resource = resource;
    }

    @Override
    public String getName() {
        return resource.getName();
    }

    @Override
    public int getAge() {
        return resource.getAge();
    }
}
