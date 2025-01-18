package ru.otus.java.basic.homeworks.hw9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainHomework9App {
    public static void main(String[] args) {
        try {
            List<Integer> array = createArray(4, 100);
            System.out.println(sumElements(array));
            addValues(1, array);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(31, "Мария"));
        employees.add(new Employee(18, "Андрей"));
        employees.add(new Employee(48, "Анатолий"));
        System.out.println(getEmployeeNames(employees));
        System.out.println(getOlderThan(20, employees));
        System.out.println(isOlderThan(40, employees));
        System.out.println(getYoungest(employees));
    }

    public static ArrayList<Integer> createArray(int min, int max) {
        if (max < min) throw new RuntimeException("Массив не может быть создан, максимум меньше минимума");
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            result.add(i);
        }
        return result;
    }

    public static LinkedList<Integer> createLinkedList(int min, int max) {
        if (max < min) throw new RuntimeException("Массив не может быть создан, максимум меньше минимума");
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = min; i <= max; i++) {
            result.add(i);
        }
        return result;
    }

    /**
     * Суммирует все элементы, значение которых больше 5
     *
     * @param array - массив для суммирования
     * @return полученная сумма
     */
    public static int sumElements(List<Integer> array) {
        long startTime = System.nanoTime();
        int sum = 0;
        for (Integer i : array) {
            if (i > 5) sum += i;
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime + " нс");
        return sum;
    }

    /**
     * Заменяет все непустые значения в списке на указанное
     *
     * @param value - значение, которое будет у всех элементов списка
     * @param list  - список
     * @return список с замененными значениями
     */
    public static List<Integer> replaceValues(int value, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) list.set(i, value);
        }
        return list;
    }

    /**
     * Увеличивает все значения в списке на указанное число
     *
     * @param value - значение, на которое надо увеличить все элементы списка
     * @param list  - список
     * @return список, в котором значения всех элементов увеличены на value
     */
    public static List<Integer> addValues(int value, List<Integer> list) {
        list.replaceAll(integer -> value + integer);
        return list;
    }

    /**
     * Возвращает список имен сотрудников
     *
     * @param employees - список сотрудников
     * @return список значений name сотрудников
     */
    public static List<String> getEmployeeNames(List<Employee> employees) {
        ArrayList<String> names = new ArrayList<>();
        for (Employee person : employees) {
            names.add(person.getName());
        }
        return names;
    }

    /**
     * Возвращает список сотрудников старше указанного возраста
     *
     * @param age       - возраст, сотрудники старше которого вычисляются
     * @param employees - список сотрудников
     * @return - список сотрудников, у которых значение age больше указанного
     */
    public static List<Employee> getOlderThan(int age, List<Employee> employees) {
        ArrayList<Employee> elders = new ArrayList<>();
        for (Employee person : employees) {
            if (person.getAge() > age) elders.add(person);
        }
        return elders;
    }

    /**
     * Проверят, больше ли средний возраст сотрудников указанного значения
     *
     * @param age       - среднее значение возраста
     * @param employees - список сотрудников
     * @return true, если средний возраст сотрудников превышает age, иначе false
     */
    public static boolean isOlderThan(int age, List<Employee> employees) {
        int ageSum = 0;
        for (Employee person : employees) {
            ageSum += person.getAge();
        }
        return ageSum / employees.size() > age;
    }

    /**
     * Возвращает самого юного сотрудника
     *
     * @param employees список сотрудников
     * @return первого по списку сотрудника с наименьшим значением age
     */
    public static Employee getYoungest(List<Employee> employees) {
        Employee youngster = employees.get(0);
        for (Employee person : employees) {
            if (youngster.getAge() > person.getAge()) youngster = person;
        }
        return youngster;
    }
}
