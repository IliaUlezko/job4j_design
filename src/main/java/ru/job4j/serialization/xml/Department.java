package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "department")
public class Department {

    @XmlAttribute
    private int id;
    @XmlAttribute
    private String division;

    public Department() {

    }

    public Department(int id, String division) {
        this.id = id;
        this.division = division;
    }

    @Override
    public String toString() {
        return "Department{"
                + "id=" + id
                + ", division='" + division + '\''
                + '}';
    }
}
