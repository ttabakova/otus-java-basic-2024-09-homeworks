package ru.otus.java.basic.homeworks.hw4;

/**
 * Создайте класс Пользователь (User) с полями: фамилия, имя, отчество, год рождения, email;
 * Реализуйте у класса конструктор, позволяющий заполнять эти поля при создании объекта;
 * В классе Пользователь реализуйте метод, выводящий в консоль информацию о пользователе в виде:
 * ФИО: фамилия имя отчество
 * Год рождения: год рождения
 * e-mail: email
 */
public class User {
    private String name; //Имя пользователя
    private String surname; //Фамилия пользователя
    private String patronymic; //Отчество
    private int yearOfBirth; //Год рождения
    private String email; //Адрес электронной почты

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String surname, String name, int yearOfBirth) {
        this.surname = surname;
        this.name = name;
        this.patronymic = "";
        this.yearOfBirth = yearOfBirth;
        this.email = "";
    }

    public User(String surname, String name, String patronymic, int yearOfBirth, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    /**
     * Печатает в консоль информациб о ползователе в формате:
     * ФИО: surname name patronymic
     * Год рождения: yearOfBirth
     * Email: email
     */
    public void print() {
        System.out.println("ФИО: " + surname + " " + name + " " + patronymic);
        System.out.println("Год рождения: " + yearOfBirth);
        System.out.println("Email: " + email);
    }
}
