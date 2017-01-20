package ru.dolgov.web.resources;

/**
 * TestResource class for deserialization xml file
 * @author M. Dolgov
 * 09.01.2017.
 */
public class TestResources {
    private String name;
    private int age;

    /**
     * Constructor with parameters
     * @param name
     * @param age
     */
    public TestResources(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Default constructor
     */
    public TestResources() {
        this.name = "";
        this.age = 0;
    }

    /**
     * Getter field name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Getter field age
     * @return
     */
    public int getAge() {
        return age;
    }
}