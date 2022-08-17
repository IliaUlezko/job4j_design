package ru.job4j.serialization.xml;

import java.util.Arrays;

public class Employee {

    private final String name;
    private final int age;
    private final boolean distantWork;

    private final Department department;

    private final String[] contacts;

    public Employee(String name, int age,
                    boolean distantWork, Department department,
                    String[] contacts) {
        this.name = name;
        this.age = age;
        this.distantWork = distantWork;
        this.department = department;
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", distantWork=" + distantWork
                + ", department=" + department
                + ", contacts=" + Arrays.toString(contacts)
                + '}';
    }
}
