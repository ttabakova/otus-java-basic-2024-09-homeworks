package ru.otus.java.basic.homeworks.hw9;

public class Employee {
    private final int age;
    private final String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return name + ", " + age;
    }
}
