package ru.otus.java.basic.homeworks.hw7;

public class Human {
    private final String name;
    private Transport currentTransport;
    private int stamina;

    public String getName() {
        return name;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public Human(String name, int stamina) {
        this.name = name;
        this.stamina = stamina;
    }

    public void getOn(Transport transport) {
        if (this.currentTransport!=null){
            System.out.println("Необходимо слезть с текущего транспорта");
            return;
        }
        this.currentTransport = transport;
        currentTransport.getOn(this);
    }

    public void getOff() {
        currentTransport.getOff();
        this.currentTransport = null;
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
