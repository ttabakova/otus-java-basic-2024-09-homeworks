package ru.otus.java.basic.homeworks.hw10;

import java.util.HashSet;

public class Contact {
    private final String name;
    private HashSet<String> phoneNumbers;

    public Contact(String name) {
        this.name = name;
        this.phoneNumbers = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public HashSet<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void addNumber(String number) {
        phoneNumbers.add(number);
    }

    @Override
    public String toString() {
        return "{" +
                "Имя:'" + name + '\'' +
                ", Контакты:" + phoneNumbers +
                '}';
    }
}
