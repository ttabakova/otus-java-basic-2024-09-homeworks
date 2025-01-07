package ru.otus.java.basic.homeworks.hw7;

public class MainHomework7App {
    public static void main(String[] args) {
        Transport car = new Car(100);
        Transport suv = new Suv(200);
        Transport horse = new Horse(50);
        Transport bycicle = new Bycicle();
        Human subject = new Human("Подопытный №1", 200);
        subject.sit(car);
        subject.move(20,Terrain.FOREST);
        subject.move(20, Terrain.PLAIN);
        subject.sit(suv);
        subject.move(30, Terrain.SWAMP);
        subject.move(200, Terrain.FOREST);
        subject.sit(bycicle);
        subject.move(20, Terrain.SWAMP);
        subject.move(20, Terrain.PLAIN);
        subject.stand();
        subject.move(10, Terrain.SWAMP);
        subject.sit(horse);
        subject.move(20,Terrain.FOREST);
    }
}
