package ru.otus.java.basic.homeworks.hw10;

public class MainHomework10App {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Николай", "+7 911 987 65 43");
        phoneBook.add("Алексей", "+7 921 123 45 67");
        phoneBook.add("Алексей", "+7 921 123 45 67");
        phoneBook.add("Алексей", "+7 812 580 38 74");
        System.out.println(phoneBook);
        System.out.println(phoneBook.find("Алексей"));
        System.out.println(phoneBook.find("Анна"));
        System.out.println(phoneBook.containsPhoneNumber("12345"));
        System.out.println(phoneBook.containsPhoneNumber("+7 921 123 45 67"));
    }
}
