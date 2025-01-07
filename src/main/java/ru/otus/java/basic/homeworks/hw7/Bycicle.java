package ru.otus.java.basic.homeworks.hw7;

public class Bycicle implements Transport {

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (!terrain.equals(Terrain.SWAMP)) {
            System.out.println("Велосипед проехал " + distance + " км. по " + terrain);
            return true;
        } else {
            System.out.println("Перемещение не выполнено. Велосипед не может перемещаться по болоту");
            return false;
        }
    }

    @Override
    public void sitInfo() {
        System.out.println("Человек сел на велосипед");
    }
}
