package ru.otus.java.basic.homeworks.hw11;

public class MainHomework11App {

    public static void main(String[] args) {
        int[] testArray = new int[]{6,4,7,3,1,9,2,5,8};
        SearchTreeImpl searchTree = new SearchTreeImpl();
        for (int i : testArray) {
            searchTree.add(i);
        }
        System.out.println(searchTree);
        System.out.println(searchTree.find(1));
        System.out.println(searchTree.getSortedList());
    }
}
