package ru.otus.java.basic.homeworks.hw6;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Plate plate) {
        if (plate.getAmount() > appetite) {
            plate.extract(appetite);
            fullness = true;
            System.out.println("Кот " + name + " поел");
        } else {
            System.out.println("В тарелке недостаточно еды для кота " + name);
            this.fullness = false;
        }
    }

    public void info() {
        System.out.println("Кот " + name + ": аппетит - " + appetite + "; состояние - " + (fullness ? "сыт" : "голоден"));
    }
}
