package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private boolean distantWork;

    @XmlElement
    private Department department;

    @XmlElementWrapper(name = "contacts")
    @XmlElement(name = "contact")
    private String[] contacts;

    public Employee() {

    }

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