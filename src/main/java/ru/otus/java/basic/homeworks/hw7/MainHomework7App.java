package ru.otus.java.basic.homeworks.hw7;

public class MainHomework7App {
    public static void main(String[] args) {
        Transport car = new Car(100);
        Transport suv = new Suv(200);
        Transport horse = new Horse(50);
        Transport bycicle = new Bycicle();
        Human subject = new Human("Подопытный №1", 200);
        subject.getOn(car);
        subject.move(20,Terrain.FOREST);
        subject.move(20, Terrain.PLAIN);
        subject.getOff();
        subject.getOn(suv);
        subject.move(30, Terrain.SWAMP);
        subject.move(200, Terrain.FOREST);
        subject.getOn(bycicle);
        subject.getOff();
        subject.getOn(bycicle);
        subject.move(20, Terrain.SWAMP);
        subject.move(20, Terrain.PLAIN);
        subject.getOff();
        subject.move(10, Terrain.SWAMP);
        subject.getOn(horse);
        subject.move(20,Terrain.FOREST);
    }
}
