package ru.otus.java.basic.homeworks.hw10;

import java.util.HashSet;

public class PhoneBook {
    private HashSet<Contact> contacts;

    public PhoneBook() {
        contacts = new HashSet<>();
    }

    /**
     * Добавляет в телефонную книгу контакт с указанными именем и номером телефона.
     * Если имя уже есть в телефонной книге, номер добавляется к списку номеров для данного имени.
     * @param name - имя контакта
     * @param number - телефонный номер контакта
     */
    public void add(String name, String number) {
        Contact newContact = null;
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                newContact = c;
                break;
            }
        }
        if (newContact == null) newContact = new Contact(name);
        newContact.addNumber(number);
        contacts.add(newContact);
    }

    /**
     * Ищет контакты по указанному имени
     * @param name имя
     * @return список номеров телефонов, записанных по указанным именем
     */
    public HashSet<String> find (String name){
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                return c.getPhoneNumbers();
            }
        }
        return new HashSet<>();
    }

    /**
     * Проверяет наличие номера телефона в телефонной книге
     * @param number - номер для проверки
     * @return true, если номер телефона присутствует в телефонной книге, false - если отсутствует
     */
    public boolean containsPhoneNumber (String number){
        for (Contact c : contacts) {
            if (c.getPhoneNumbers().contains(number)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return contacts.toString();
    }
}
