package ru.otus.java.basic.homeworks.hw6;

public class MainHomework6App {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        plate.fill(120);
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Барсик", 20);
        cats[1] = new Cat("Мурзик", 10);
        cats[2] = new Cat("Пушок", 30);
        cats[3] = new Cat("Дьявол", 50);
        for (Cat cat : cats) {
            cat.eat(plate);
        }
    }
}
