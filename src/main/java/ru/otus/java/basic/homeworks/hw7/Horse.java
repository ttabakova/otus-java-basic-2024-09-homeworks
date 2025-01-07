package ru.otus.java.basic.homeworks.hw7;

public class Horse implements Transport {
    private int stamina;
    private Human driver;

    public Horse(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public void getOn(Human driver) {
        this.driver = driver;
        System.out.println(driver.getName() + " сел на лошадь");
    }

    @Override
    public void getOff() {
        System.out.println(driver.getName() + " слез с лошади");
        this.driver = null;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (!terrain.equals(Terrain.SWAMP)) {
            if (stamina - distance >= 0) {
                stamina -= distance;
                System.out.println("Лошадь проскакала " + distance + " км. по " + terrain + ". Осталось " + stamina + " ед. сил");
                return true;
            } else {
                System.out.println("Перемещение не выполнено. Недостаточно сил для перемещения");
                return false;
            }
        } else {
            System.out.println("Перемещение не выполнено. Лошадь не может перемещаться по болоту");
            return false;
        }
    }


}
