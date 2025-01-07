package ru.otus.java.basic.homeworks.hw7;

public class Human {
    private final String name;
    private Transport currentTransport;
    private int stamina;

    public Human(String name, int stamina) {
        this.name = name;
        this.stamina = stamina;
    }

    public void sit(Transport transport) {
        this.currentTransport = transport;
        currentTransport.sitInfo();
    }

    public void stand() {
        this.currentTransport = null;
        System.out.println("Человек слез с транспорта");
    }

    public void move(int distance, Terrain terrain) {
        if (currentTransport == null) {
            //Считаем, что человек тратит 5 ед. выносливости на 1 км
            if (stamina - distance * 5 > 0) {
                System.out.println("Человек прошел пешком " + distance + " км. по " + terrain);
                stamina -= distance * 5;
            } else {
                System.out.println("Перемещение не выполнено. Слишком длинная дистанция для того, чтобы пройти пешком");
            }
        } else {
            currentTransport.move(distance, terrain);
        }
    }
}
