package ru.otus.java.basic.homeworks.hw5;

public class MainHomework5App {
    public static void main(String[] args) {
        Animal cat1 = new Cat("Барсик", 5, 30);
        cat1.swim(10);
        cat1.run(20);
        cat1.info();
        Animal dog = new Dog("Полкан", 3,2,60);
        dog.swim(20);
        dog.run(10);
        dog.info();
        Animal horse = new Horse("Плотва", 20, 1, 100);
        horse.swim(10);
        horse.run(100);
        horse.info();
    }
}
