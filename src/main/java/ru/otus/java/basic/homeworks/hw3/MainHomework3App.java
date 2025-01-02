package ru.otus.java.basic.homeworks.hw3;

/**
 * (1) Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив;
 * метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
 * (2) Реализовать метод, который принимает в качестве аргумента int size и печатает в консоль
 * квадрат из символов * со сторонами соответствующей длины;
 * (3) Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив,
 * и обнуляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе);
 * (4) Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
 * (5) Реализуйте метод, который считает сумму элементов второй строки двумерного массива;
 * если второй строки не существует, то в качестве результата необходимо вернуть -1
 */

public class MainHomework3App {
    public static void main(String[] args) {
        //Задача 1
        System.out.println("// Задача 1 //");
        int[][] arr1 = {{1, -1, 0}, {10, -1, 4}};
        sumOfPositiveElements(arr1);

        //Задача 2
        System.out.println("// Задача 2 //");
        printSquare(3);

        //Задача 3
        System.out.println("// Задача 3 //");
        int[][] arr2 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        resetMainDiagonal(arr2);
        System.out.println("// ------- //");
        int[][] arr2Alt = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        resetSecondaryDiagonal(arr2Alt);//можно было сделать одним методом, передавая на вход, которую диагональ обнулять, но я не смогла придумать название переменной

        //Задача 4
        System.out.println("// Задача 4 //");
        int[][] arr3 = {{-1, -2, -20}, {1, 2, 3}, {3, 5, -100}};
        findMax(arr3);

        //Задача 5
        System.out.println("// Задача 5 //");
        int[][] arr4 = {{1, 1, 1}, {2, 2, 2}};
        sumSecondRow(arr4);
    }

    /**
     * Суммирует положительные элементы двумерного массива
     *
     * @param requestArray - массив для суммирования
     * @return сумма положительных элементов
     */
    public static int sumOfPositiveElements(int[][] requestArray) {
        int resultSum = 0;
        for (int i = 0; i < requestArray.length; i++) {
            for (int j = 0; j < requestArray[i].length; j++) {
                if (requestArray[i][j] > 0) resultSum += requestArray[i][j];
            }
        }
        System.out.println("Сумма положительных элементов массива равна " + resultSum);
        return resultSum;
    }

    /**
     * Печатает в консоль квадрат из * указанного размера
     *
     * @param size - размер стороны квадрата
     */
    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * Печатает в консоль двумерный целочисленный массив
     *
     * @param requestArray - массив для печати
     */
    public static void print2DIntArray(int[][] requestArray) {
        for (int i = 0; i < requestArray.length; i++) {
            for (int j = 0; j < requestArray[i].length; j++) {
                System.out.print(requestArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Обнуляет главную диагональ двумерного массива
     *
     * @param requestArray - массив для обнуления диагонали
     */
    public static void resetMainDiagonal(int[][] requestArray) {
        for (int i = 0; i < requestArray.length; i++) {
            requestArray[i][i] = 0;
        }
        print2DIntArray(requestArray);
    }

    /**
     * Обнуляет побочную диагональ двумерного массива
     *
     * @param requestArray - массив для обнуления диагонали
     */
    public static void resetSecondaryDiagonal(int[][] requestArray) {
        int position;
        for (int i = 0; i < requestArray.length; i++) {
            position = requestArray.length - i - 1;
            requestArray[position][i] = 0;
        }
        print2DIntArray(requestArray);
    }

    /**
     * Возвращает максимальный элемент двумерного массива
     *
     * @param requestArray - массив для поиска
     * @return максимальный элемент массива
     */
    public static int findMax(int[][] requestArray) {
        int maxElement = requestArray[0][0];
        for (int i = 0; i < requestArray.length; i++) {
            for (int j = 0; j < requestArray[i].length; j++) {
                if (requestArray[i][j] > maxElement) maxElement = requestArray[i][j];
            }
        }
        System.out.println("Максимальный элемент массива равен " + maxElement);
        return maxElement;
    }

    /**
     * Суммирует элементы второй строки массива. "Вторая" строка - вторая по порядку, а не по нумерации (которая начинается с 0)
     *
     * @param requestArray - входящий массив
     * @return полученная сумма; если у массива нет второй строки, возвращает -1
     */
    public static int sumSecondRow(int[][] requestArray) {
        int resultSum = 0;
        if (requestArray.length < 2) {
            resultSum = -1;
            System.out.println("У входящего массива нет второй строки");
        } else {
            for (int i = 0; i < requestArray[1].length; i++) {
                resultSum += requestArray[1][i];
            }
            System.out.println("Сумма элементов второй строки массива равна " + resultSum);
        }
        return resultSum;
    }

}