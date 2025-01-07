package ru.otus.java.basic.homeworks.hw7;

/**
 * Вездеход
 */
public class Suv implements Transport {
    private int petrol;
    private Human driver;

    public Suv(int petrol) {
        this.petrol = petrol;
    }

    @Override
    public void getOn(Human driver) {
        this.driver = driver;
        System.out.println(driver.getName()+ " сел в вездеход");
    }

    @Override
    public void getOff() {
        System.out.println(driver.getName() + " вылез из вездехода");
        this.driver = null;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (driver ==null){
            System.out.println("Перемещение не выполнено. Вездеход не может ехать без водителя");
            return false;
        }
        if (petrol - distance >= 0) {
            petrol -= distance;
            System.out.println("Вездеход проехал " + distance + " км. по " + terrain + ". Осталось " + petrol + " л. бензина");
            return true;
        } else {
            System.out.println("Перемещение не выполнено. Недостаточно бензина для перемещения");
            return false;
        }
    }
}
