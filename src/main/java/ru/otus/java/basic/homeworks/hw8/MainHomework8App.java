package ru.otus.java.basic.homeworks.hw8;

public class MainHomework8App {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "собака", "1"},
                {"1", "1", "1", "1"}
        };
        try {
            System.out.println("Успешно просуммировали значения ячеек массива, результат равен " + sumArray(array));
        } catch (AppArraySizeException | AppArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int sumArray(String[][] array) throws AppArraySizeException, AppArrayDataException {
        int sum = 0;
        if (array.length != 4) throw new AppArraySizeException("Массив некорректного размера");
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) throw new AppArraySizeException("Массив некорректного размера");
            else {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new AppArrayDataException("Обнаружено не целое число в ячейке ", i, j);
                    }
                }
            }
        }
        return sum;
    }
}
