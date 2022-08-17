package ru.job4j.serialization.xml;

public class Department {

    private final int id;
    private final String division;

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
