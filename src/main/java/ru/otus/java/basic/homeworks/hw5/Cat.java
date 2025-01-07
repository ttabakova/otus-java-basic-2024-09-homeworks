package ru.otus.java.basic.homeworks.hw5;

public class Cat extends Animal {
    public Cat(String name, int runningSpeed, int stamina) {
        super(name, runningSpeed, stamina);
    }

    @Override
    public int swim(int distance) {
        System.out.println("Кот не умеет плавать");
        return -1;
    }

    @Override
    public void info() {
        System.out.println("Кот " + this.name);
        System.out.println("Выносливость: " + this.stamina);
        System.out.println("Скорость бега: " + this.runningSpeed);
        System.out.println("Скорость плавания: коты не плавают");
    }
}
