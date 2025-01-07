package ru.otus.java.basic.homeworks.hw5;

public class Horse extends Animal {
    public Horse(String name, int runningSpeed, int swimmingSpeed, int stamina) {
        super(name, runningSpeed, swimmingSpeed, stamina);
    }

    public int swim(int distance) {
        return super.swim(distance, 4);
    }

    public void info() {
        System.out.println("Лошадь " + this.name);
        super.info();
    }
}
