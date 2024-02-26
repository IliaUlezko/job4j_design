package ru.job4j.serialization.json;

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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isDistantWork() {
        return distantWork;
    }

    public Department getDepartment() {
        return department;
    }

    public String[] getContacts() {
        return contacts;
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