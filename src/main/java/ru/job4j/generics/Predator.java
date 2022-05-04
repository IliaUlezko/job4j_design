package ru.job4j.generics;

public class Predator extends Animal {
    public Predator(int age, String name) {
        super(age, name);
    }

    @Override
    public String toString() {
        return "Predator{}";
    }
}
