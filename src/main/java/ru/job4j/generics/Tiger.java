package ru.job4j.generics;

public class Tiger extends Predator {
    public Tiger(int age, String name) {
        super(age, name);
    }

    @Override
    public String toString() {
        return "Tiger{}";
    }
}
