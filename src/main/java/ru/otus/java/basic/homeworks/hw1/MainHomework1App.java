package ru.otus.java.basic.homeworks.hw1;

import java.util.Scanner;

/**
 * (1) Реализуйте метод greetings(), который при вызове должен отпечатать в столбец 4 слова: Hello, World, from, Java;
 * (2) Реализуйте метод checkSign(..), принимающий в качестве аргументов 3 int переменные a, b и c. Метод должен посчитать их сумму, и если она больше или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
 * (3) Реализуйте метод selectColor() в теле которого задайте int переменную data с любым начальным значением. Если data меньше 10 включительно, то в консоль должно быть выведено сообщение “Красный”, если от 10 до 20 включительно, то “Желтый”, если больше 20 - “Зеленый”;
 * (4) Реализуйте метод compareNumbers(), в теле которого объявите две int переменные a и b с любыми начальными значениями. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
 * (5) Создайте метод addOrSubtractAndPrint(int initValue, int delta, boolean increment). Если increment = true, то метод должен к initValue прибавить delta и отпечатать в консоль результат, в противном случае - вычесть;
 * Каждый метод последовательно вызовите из метода main();
 * (*) При запуске приложения, запросите у пользователя число от 1 до 5, и после ввода выполнения метод, соответствующий указанному номеру со случайным значением аргументов;
 */
public class MainHomework1App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите число от 1 до 5:");
            int methodNumber = scanner.nextInt();
            if (methodNumber == 1) {
                greetings();
                break;
            } else if (methodNumber == 2) {
                checkSign((int) (Math.random() * 200 - 100), (int) (Math.random() * 200 - 100), (int) (Math.random() * 200 - 100));
                break;
            } else if (methodNumber == 3) {
                selectColor();
                break;
            } else if (methodNumber == 4) {
                compareNumbers();
                break;
            } else if (methodNumber == 5) {
                boolean randomBoolean = Math.random() < 0.5;
                addOrSubtractAndPrint((int) (Math.random() * 200 - 100), (int) (Math.random() * 200 - 100), randomBoolean);
                break;
            } else {
                System.out.println("Неверный номер задания. Попробуйте еще раз.");
            }
        }

    }

    /**
     * Метод greetings(), который при вызове должен отпечатать в столбец 4 слова: Hello, World, from, Java
     */
    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    /**
     * Метод checkSign(..), принимающий в качестве аргументов 3 int переменные a, b и c.
     * Метод должен посчитать их сумму, и если она больше или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
     *
     * @param a - первое слагаемое
     * @param b - второе слагаемое
     * @param c - третье слагаемое
     */
    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма " + a + ", " + b + " и " + c + " положительная");
        } else {
            System.out.println("Сумма " + a + ", " + b + " и " + c + " отрицательная");
        }
    }

    /**
     * Метод selectColor() в теле которого задайте int переменную data с любым начальным значением.
     * Если data меньше 10 включительно, то в консоль должно быть выведено сообщение “Красный”, если от 10 до 20 включительно, то “Желтый”, если больше 20 - “Зеленый”;
     */
    public static void selectColor() {
        int data = 10;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    /**
     * Метод compareNumbers(), в теле которого объявите две int переменные a и b с любыми начальными значениями. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
     */
    public static void compareNumbers() {
        int a = 5;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    /**
     * Метод addOrSubtractAndPrint(int initValue, int delta, boolean increment). Если increment = true, то метод должен к initValue прибавить delta и отпечатать в консоль результат, в противном случае - вычесть;
     *
     * @param initValue - начальное значение
     * @param delta     - прибавляемое или вычитаемое значение
     * @param increment - определяет выполняемую операцию: true - прибавить, false - вычесть
     */
    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println("Сумма чисел равна " + (initValue + delta));
        } else {
            System.out.println("Разница чисел равна " + (initValue - delta));
        }
    }

}
