package ru.otus.java.basic.homeworks.hw11;

import java.util.ArrayList;
import java.util.List;

public class SearchTreeImpl implements SearchTree<Integer> {
    private Node root;

    public SearchTreeImpl(Node root) {
        this.root = root;
    }

    public SearchTreeImpl() {
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (root == null) root = newNode;
        else {
            Node currentNode = root;
            while (true) {
                if (value == currentNode.getValue()) return;
                if (value < currentNode.getValue()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        return;
                    } else currentNode = currentNode.getLeft();
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        return;
                    } else currentNode = currentNode.getRight();
                }
            }
        }
    }

    @Override
    public Integer find(Integer element) {
        Node currentNode = root;
        while (true) {
            if (currentNode == null) return null;
            else if (currentNode.getValue() == element) return currentNode.getValue();
            else if (currentNode.getValue() > element) currentNode = currentNode.getLeft();
            else currentNode = currentNode.getRight();
        }
    }

    @Override
    public List<Integer> getSortedList() {
        List<Integer> result = new ArrayList<>();
        Node currentNode = root;
        if (currentNode.getLeft() != null) result.addAll((new SearchTreeImpl(currentNode.getLeft()).getSortedList()));
        result.add(currentNode.getValue());
        if (currentNode.getRight() != null) result.addAll((new SearchTreeImpl(currentNode.getRight()).getSortedList()));
        return result;
    }

    @Override
    public String toString() {
        return "SearchTreeImpl{" +
                "root=" + root +
                '}';
    }
}
