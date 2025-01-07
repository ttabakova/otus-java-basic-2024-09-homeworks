package ru.otus.java.basic.homeworks.hw7;

/**
 * Вездеход
 */
public class Suv implements Transport {
    private int petrol;

    public Suv(int petrol) {
        this.petrol = petrol;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (petrol - distance >= 0) {
            petrol -= distance;
            System.out.println("Вездеход проехал " + distance + " км. по " + terrain + ". Осталось " + petrol + " л. бензина");
            return true;
        } else {
            System.out.println("Перемещение не выполнено. Недостаточно бензина для перемещения");
            return false;
        }

    }

    @Override
    public void sitInfo() {
        System.out.println("Человек сел в вездеход");
    }
}
