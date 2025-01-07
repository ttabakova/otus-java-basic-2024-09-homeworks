package ru.otus.java.basic.homeworks.hw7;

public class Bycicle implements Transport {
    private Human driver;

    public void getOn(Human driver) {
        this.driver = driver;
        System.out.println(driver.getName() + " сел на велосипед");
    }

    public void getOff() {
        System.out.println(driver.getName() + " слез с велосипеда");
        this.driver = null;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (driver == null) {
            System.out.println("Перемещение не выполнено. Велосипед не может ехать без водителя");
            return false;
        }
        if (!terrain.equals(Terrain.SWAMP)) {
            int driverStamina = driver.getStamina() - distance*2;
            if (driverStamina > 0) {
                System.out.println("Велосипед проехал " + distance + " км. по " + terrain + ". У водителя осталось "+driverStamina + " выносливости");
                driver.setStamina(driverStamina);
                return true;
            } else {
                System.out.println("Перемещение не выполнено. У человека недостаточно сил для дистанции");
                return false;
            }
        } else {
            System.out.println("Перемещение не выполнено. Велосипед не может перемещаться по болоту");
            return false;
        }
    }
}
