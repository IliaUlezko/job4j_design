package ru.job4j.generics;

public class Animal {

    private final int age;
    private final String name;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "age=" + age
                + ", name='" + name
                + '\'' + '}';
    }
}
