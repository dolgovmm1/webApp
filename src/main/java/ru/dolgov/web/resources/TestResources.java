package ru.dolgov.web.resources;

/**
 * BigComp
 * 09.01.2017.
 */
public class TestResources {
    private String name;
    private int age;

    public TestResources(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestResources() {
        this.name = "";
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
