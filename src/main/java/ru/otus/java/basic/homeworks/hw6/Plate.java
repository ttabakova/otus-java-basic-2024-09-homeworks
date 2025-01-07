package ru.otus.java.basic.homeworks.hw6;

public class Plate {
    private final int maxAmount;
    private int amount;

    public Plate(int maxAmount) {
        this.maxAmount = maxAmount;
        this.amount = 0;
    }

    public int getAmount() {
        return amount;
    }

    public void fill(int amount) {
        this.amount = Math.min(this.amount + amount, maxAmount);
        System.out.println("Наполнили тарелку до " + this.amount + " еды");
    }

    public boolean extract(int amount) {
        if (this.amount - amount > 0){
            this.amount -= amount;
            System.out.println("Извлекли еду из тарелки, осталось " + this.amount);
            return true;
        } else {
            System.out.println("В тарелке не хватило еды");
            this.amount = 0;
            return false;
        }
    }
}
