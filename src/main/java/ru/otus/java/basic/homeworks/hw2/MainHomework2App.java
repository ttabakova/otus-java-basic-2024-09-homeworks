package ru.otus.java.basic.homeworks.hw2;

import java.lang.reflect.Array;

/**
 * (1) Реализуйте метод, принимающий в качестве аргументов целое число и строку,
 * и печатающий в консоль строку указанное количество раз
 * (2) Реализуйте метод, принимающий в качестве аргумента целочисленный массив,
 * суммирующий все элементы, значение которых больше 5, и печатающий полученную сумму в консоль.
 * (3) Реализуйте метод, принимающий в качестве аргументов целое число и ссылку
 * на целочисленный массив, метод должен заполнить каждую ячейку массива указанным числом.
 * (4) Реализуйте метод, принимающий в качестве аргументов целое число и ссылку
 * на целочисленный массив, увеличивающий каждый элемент которого на указанное число.
 * (5) Реализуйте метод, принимающий в качестве аргумента целочисленный массив,
 * и печатающий в консоль сумма элементов какой из половин массива больше.
 */
public class MainHomework2App {
    public static void main(String[] args) {
        //задача 1
        printStringMultiple(1,"Hello World");

        //задача 2
        int[] terms = {1,2,3,4};
        sumArray(terms);

        //задача 3
        int[] arr = new int[5];
        fillArray(arr, 1);

        //задача 4
        increaseValues(arr,2);

        //вывод результата для задачи 3 и/или 4
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //задача 5
        compareArrayHalves(new int[]{1, 1, 1, 1, 1});
    }

    /**
     * Печатает строку в консоль указанное количество раз
     *
     * @param count       - количество раз, которые необходимо распечатать строку
     * @param printString - строка, которую необходимо распечатать
     */
    public static void printStringMultiple(int count, String printString) {
        for (int i = 0; i < count; i++) {
            System.out.println(printString);
        }
    }

    /**
     * Суммирует все элементы полученного на вход массива и печатает результат
     *
     * @param terms - массив слагаемых
     */
    public static void sumArray(int[] terms) {
        int result = 0;
        for (int i = 0; i < terms.length; i++) {
            result += terms[i];
        }
        System.out.println("Сумма элементов массива равна " + result);
    }

    /**
     * Заполняет все элементы массива указанным числом
     *
     * @param requestArray - массив, которые необходимо заполнить
     * @param contents     - число для заполнения
     * @return полученный массив
     */
    public static int[] fillArray(int[] requestArray, int contents) {
        for (int i = 0; i < requestArray.length; i++) {
            requestArray[i] = contents;
        }
        return requestArray;
    }

    /**
     * Прибавляет указанное число ко всем элементам массива
     *
     * @param requestArray - массив для увеличения элементов
     * @param terms        - число, на которое необходимо увеличить значение элементов массива
     * @return полученный массив
     */
    public static int[] increaseValues(int[] requestArray, int terms) {
        for (int i = 0; i < requestArray.length; i++) {
            requestArray[i] += terms;
        }
        return requestArray;
    }

    /**
     * Определяет, сумма которой половины целочисленного массива больше.
     * Если длина массива нечетная, элемент посередине игнорируется в обеих суммах.
     *
     * @param requestArray - массив для сравнения
     */
    public static void compareArrayHalves(int[] requestArray) {
        int firstHalfSum = 0;
        int lastHalfSum = 0;
        //Суммируем первую половину массива - для нечетной длины будет округление в меньшую сторону по умолчанию
        for (int i = 0; i < requestArray.length / 2; i++) {
            firstHalfSum += requestArray[i];
        }
        //Определяем середину
        int arrayHalf;
        if (requestArray.length / 2 == 0) {
            arrayHalf = requestArray.length / 2;
        } else {
            arrayHalf = requestArray.length / 2 + 1;//если длина нечетная, то начинаем со следующего за элементом посередине
        }
        //Суммируем вторую половину элементов массива
        for (int i = arrayHalf; i < requestArray.length; i++) {
            lastHalfSum += requestArray[i];
        }
        //Сравниваем полученные суммы и печатаем результат
        if (firstHalfSum > lastHalfSum) {
            System.out.println("Сумма первой половины элементов массива " + firstHalfSum +
                    " БОЛЬШЕ суммы второй половины элементов массива " + lastHalfSum);
        } else if (firstHalfSum < lastHalfSum) {
            System.out.println("Сумма первой половины элементов массива " + firstHalfSum +
                    " МЕНЬШЕ суммы второй половины элементов массива " + lastHalfSum);
        } else {
            System.out.println("Сумма первой половины элементов массива " + firstHalfSum +
                    " РАВНА сумме второй половины элементов массива");
        }
    }
}
