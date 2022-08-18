package ru.job4j.serialization.json;

public class Department {

    private final int id;
    private final String division;

    public Department(int id, String division) {
        this.id = id;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public String getDivision() {
        return division;
    }

    @Override
    public String toString() {
        return "Department{"
                + "id=" + id
                + ", division='" + division + '\''
                + '}';
    }
}