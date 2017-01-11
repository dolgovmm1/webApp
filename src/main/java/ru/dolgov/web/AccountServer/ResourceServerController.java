package ru.dolgov.web.AccountServer;

import resources.TestResource;

/**
 * BigComp
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
