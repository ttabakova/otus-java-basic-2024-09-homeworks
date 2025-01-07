package ru.otus.java.basic.homeworks.hw5;

public abstract class Animal {
    String name;
    int runningSpeed;
    int swimmingSpeed;
    int stamina;
    boolean active;

    public Animal(String name, int runningSpeed, int swimmingSpeed, int stamina) {
        this.name = name;
        this.runningSpeed = runningSpeed;
        this.swimmingSpeed = swimmingSpeed;
        this.stamina = stamina;
        active = true;
    }

    public Animal(String name, int runningSpeed, int stamina) {
        this.name = name;
        this.runningSpeed = runningSpeed;
        this.swimmingSpeed = 0;
        this.stamina = stamina;
        active = true;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /**
     * Реализует действие "бежать" для животного. Понижает выносливость животного в зависимости от дистанции. Все животные тратят 1 ед. выносливости на 1 метр
     * Если выносливости не хватило на всю дистанцию, животное получает усталость (active = false), иначе получает активность (active = true)
     * @param distance - дистанция бега
     * @return время бега, если выносливости хватило на всю дистанцию, иначе -1
     */
    public int run(int distance) {
        int time = distance / this.runningSpeed;
        if (this.stamina - distance > 0) {
            System.out.println(this.name + " пробежал " + distance + " метров за " + time + " секунд");
            this.stamina -= distance;
            this.active = true;
            return time;
        } else {
            System.out.println(this.name + " пробежал " + this.stamina + " из " + distance + " метров за " + time + " секунд и устал");
            this.stamina = 0;
            this.active = false;
            return -1;
        }
    }

    /**
     * Реализует действие "плавать" для животного. Понижает выносливость животного в зависимости от дистанции. Все животные тратят разное количество ед. выносливости на 1 метр.
     * Если выносливости не хватило на всю дистанцию, животное получает усталость (active = false), иначе получает активность (active = true)
     * @param distance - дистанция плавания
     * @return время плавания, если выносливости хватило на всю дистанцию, иначе -1
     */
    public abstract int swim(int distance);

    /**
     * Вспомогательный внутренний метод, реализующий плавание в зависимости от количества затрачиваемой выносливости.
     * @param distance - дистанция плавания
     * @param staminaPerMeter - выностивость, затрачиваемая животным на 1 метр
     * @return время плавания, если выносливости хватило на всю дистанцию, иначе -1
     */
    protected int swim(int distance, int staminaPerMeter) {
        int time = distance / this.swimmingSpeed;
        if (this.stamina / staminaPerMeter - distance > 0) {
            System.out.println(this.name + " проплыл " + distance + " метров за " + time + " секунд");
            this.stamina -= distance * staminaPerMeter;
            this.active = true;
            return time;
        } else {
            System.out.println(this.name + " проплыл " + (this.stamina / staminaPerMeter) + " из " + distance + " метров за " + time + " секунд и устал");
            this.stamina = 0;
            this.active = false;
            return -1;
        }
    }

    /**
     * Выводит информацию о животном в консоль
     */
    public void info() {
        System.out.println("Выносливость: " + this.stamina);
        System.out.println("Скорость бега: " + this.runningSpeed);
        System.out.println("Скорость плавания: " + this.swimmingSpeed);
        System.out.println("Усталость: " + (this.active ? "нет" : "да"));
    }
}
