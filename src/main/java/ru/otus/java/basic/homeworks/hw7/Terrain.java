package ru.otus.java.basic.homeworks.hw7;

public enum Terrain {
    FOREST("густому лесу"),
    SWAMP("болоту"),
    PLAIN("равнине");

    private final String title;

    Terrain(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return this.title;
    }
}
