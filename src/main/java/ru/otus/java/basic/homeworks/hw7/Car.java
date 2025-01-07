package ru.otus.java.basic.homeworks.hw7;

public class Car implements Transport {
    private int petrol;

    public Car(int petrol) {
        this.petrol = petrol;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain.equals(Terrain.PLAIN)) {
            if (petrol - distance >= 0) {
                petrol -= distance;
                System.out.println("Машина проехала " + distance + " км. по " + terrain + ". Осталось " + petrol + " л. бензина");
                return true;
            } else {
                System.out.println("Перемещение не выполнено. Недостаточно бензина для перемещения");
                return false;
            }
        } else {
            System.out.println("Перемещение не выполнено: машина не может перемещаться по " + terrain);
            return false;
        }
    }

    @Override
    public void sitInfo() {
        System.out.println("Человек сел в машину");
    }
}
