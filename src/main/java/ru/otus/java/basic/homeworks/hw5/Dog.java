package ru.otus.java.basic.homeworks.hw5;

public class Dog extends Animal {
    public Dog(String name, int runningSpeed, int swimmingSpeed, int stamina) {
        super(name, runningSpeed, swimmingSpeed, stamina);
    }

    public int swim(int distance) {
        return super.swim(distance, 2);
    }

    public void info() {
        System.out.println("Собака " + this.name);
        super.info();
    }
}
