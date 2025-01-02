package ru.otus.java.basic.homeworks.hw4;

import java.time.Year;

public class MainHomework4App {
    public static void main(String[] args) {
        task1();
        //task2();
    }

    /**
     * В методе main() Main класса создайте массив из 10 пользователей и заполните его объектами и с помощью цикла выведите информацию только о пользователях старше 40 лет.
     * Считаем, что день рождения у всех пользователей 1 января.
     */
    public static void task1() {
        User [] users = new User[10];
        users[0] = new User("Иванов", "Иван", "Иванович", 1970, "ivanov@mail.ru");
        users[1] = new User("Петров", "Александр", "Сергеевич", 2009, "pterov2009@gmail.com");
        users[2] = new User("Сидоров", "Евгений", "Михайлович", 1999, "sidorov@yandex.ru");
        users[3] = new User("Попова", "Мария", "Андреевна", 1988, "popova@gmail.com");
        users[4] = new User("Константинопольский", "Константин",1984);
        users[5] = new User("Павлова", "Ольга", "Юрьевна", 1980, "olenka1980@mail.ru");
        users[6] = new User("Ямпольский", "Ярослав", "Дмитриевич", 1994, "");
        users[7] = new User("Антонова", "Лидия", 2012);
        users[8] = new User("Козлов", "Петр", "Сергеевич", 1985,"beeeee@mail.ru");
        users[9] = new User("У меня", "закончилась", "фантазия", 1900, "1900@gmail.com");

        int currentYear = Year.now().getValue();

        for (int i = 0; i < users.length; i++) {
            if (currentYear - users[i].getYearOfBirth() > 40) users[i].print();
        }
    }

    public static void task2(){
        Box box1 = new Box(10,30,20);
        box1.print();
        box1.recolor("красный");
        box1.close();
        box1.empty();
        box1.put("яблоко");
        box1.open();
        box1.put("груша");
        box1.print();
        box1.put("лимон");
        box1.empty();
        box1.put("шар");
        box1.print();
    }
}
