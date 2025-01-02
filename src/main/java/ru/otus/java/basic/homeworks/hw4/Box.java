package ru.otus.java.basic.homeworks.hw4;

/**
 * Объекты класса Коробка должны иметь размеры и цвет.
 * Коробку можно открывать и закрывать.
 * Коробку можно перекрашивать.
 * Изменить размер коробки после создания нельзя.
 * У коробки должен быть метод, печатающий информацию о ней в консоль.
 * В коробку можно складывать предмет (если в ней нет предмета),
 * или выкидывать его оттуда (только если предмет в ней есть),
 * только при условии, что коробка открыта (предметом читаем просто строку).
 * Выполнение методов должно сопровождаться выводом сообщений в консоль.
 */
public class Box {
    private int width;
    private int height;
    private int length;
    private String color;
    private boolean isOpened;
    private String contents;

    public Box(int width, int height, int length) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.color = "белый";
        this.isOpened = false;
    }

    /**
     * Открыта ли коробка
     * @return открыта ли коробка
     */
    public boolean isOpened() {
        return this.isOpened;
    }

    /**
     * Открыть коробку
     */
    public void open() {
        if (this.isOpened()) {
            System.out.println("Коробка уже открыта");
        } else {
            this.isOpened = true;
            System.out.println("Открыли коробку");
        }
    }

    /**
     * Закрыть коробку
     */
    public void close() {
        if (this.isOpened()) {
            this.isOpened = false;
            System.out.println("Закрыли коробку");
        } else {
            System.out.println("Коробка уже закрыта");
        }
    }

    /**
     * Перекрасить коробку в заданный цвет
     *
     * @param color - новый цвет коробки
     */
    public void recolor(String color) {
        this.color = color;
        System.out.println("Перекрасили коробку в цвет: " + color);
    }

    /**
     * Возвращает true, если коробка не пуста
     * @return true, если коробка не пуста; false - если пуста
     */
    public boolean isFilled(){
        if (this.contents == null) return false;
        else return true;
    }

    /**
     * Положить предмет в коробку. Можно положить предмет, только если коробка открыта и пуста
     * @param contents - предмет, который нужно положить в коробку
     */
    public void put(String contents){
        if (!this.isOpened){
            System.out.println("Чтобы положить что-то в коробку, ее необходимо открыть!");
        } else if (this.isFilled()) {
            System.out.println("В коробке уже лежит "+this.contents);
        } else {
            this.contents = contents;
            System.out.println("Положили в коробку "+contents);
        }
    }

    /**
     * Выкинуть содержимое из коробки
     */
    public void empty(){
        if (!this.isOpened){
            System.out.println("Чтобы опустошить коробку, ее нужно открыть");
        } else if (!this.isFilled()) {
            System.out.println("В коробке ничего не лежит");
        } else {
            this.contents = null;
            System.out.println("Опустошили коробку");
        }
    }

    public void print() {
        System.out.println("Размеры коробки: " + width + "*" + length + "*" + height);
        System.out.println("Цвет коробки: " + color);
        if (this.isOpened) System.out.println("Сейчас коробка открыта");
        else System.out.println("Сейчас коробка закрыта");
        if (this.isFilled()) System.out.println("В коробке лежит " + contents);
        else System.out.println("Коробка пуста");
    }
}
