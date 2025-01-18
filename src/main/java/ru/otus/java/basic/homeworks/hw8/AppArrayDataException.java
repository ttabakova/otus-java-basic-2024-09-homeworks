package ru.otus.java.basic.homeworks.hw8;

public class AppArrayDataException extends RuntimeException {
    private final int x;
    private final int y;

    public AppArrayDataException(String message, int x, int y) {
        super(message + x+ "," +y);
        this.x = x;
        this.y = y;
    }
}
