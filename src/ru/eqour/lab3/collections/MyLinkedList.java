package ru.eqour.lab3.collections;

import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MyLinkedList {

    private int size;
    private Node first;

    public static MyLinkedList createHead() {
        MyLinkedList list = new MyLinkedList();
        fillWithCycle(list::addFirst);
        return list;
    }

    public static MyLinkedList createTail() {
        MyLinkedList list = new MyLinkedList();
        fillWithCycle(list::addLast);
        return list;
    }

    private static void fillWithCycle(Consumer<Integer> consumer) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int listSize = in.nextInt();
        for (int i = 0; i < listSize; i++) {
            System.out.print("Введите " + (i + 1) + " элемент списка: ");
            consumer.accept(in.nextInt());
        }
    }

    public static MyLinkedList createHeadRec() {
        MyLinkedList list = new MyLinkedList();
        fillWithRecursion(list::addFirst);
        return list;
    }

    public static MyLinkedList createTailRec() {
        MyLinkedList list = new MyLinkedList();
        fillWithRecursion(list::addLast);
        return list;
    }

    private static void fillWithRecursion(Consumer<Integer> consumer) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int listSize = in.nextInt();
        fillWithRecursion(consumer, in, 0, listSize);
    }

    private static void fillWithRecursion(Consumer<Integer> consumer, Scanner in, int index, int size) {
        if (index >= size) {
            return;
        }
        System.out.print("Введите " + (index + 1) + " элемент списка: ");
        consumer.accept(in.nextInt());
        fillWithRecursion(consumer, in, index + 1, size);
    }

    public MyLinkedList() {
        first = null;
        size = 0;
    }

    public void addFirst(int value) {
        first = new Node(value, first);
        size++;
    }

    public void addLast(int value) {
        insert(size, value);
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(value);
        } else {
            Node prev = getByIndex(index - 1);
            prev.setNext(new Node(value, prev.getNext()));
            size++;
        }
    }

    public void removeFirst() {
        if (first != null) {
            first = first.getNext();
            size--;
        }
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            removeFirst();
        } else {
            Node prev = getByIndex(index - 1);
            prev.setNext(prev.getNext().getNext());
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        forEach((index, node) -> {
            if (first != node) {
                result.append(", ");
            }
            result.append(node.getValue());
        });
        result.append("]");
        return result.toString();
    }

    public String toStringRec() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        toStringRec(builder, first);
        builder.append("]");
        return builder.toString();
    }

    private void toStringRec(StringBuilder builder, Node node) {
        if (node == null) {
            return;
        }
        if (first != node) {
            builder.append(", ");
        }
        builder.append(node.getValue());
        toStringRec(builder, node.getNext());
    }

    private void forEach(BiConsumer<Integer, Node> consumer) {
        int counter = 0;
        Node node = first;
        while (node != null) {
            consumer.accept(counter, node);
            counter++;
            node = node.getNext();
        }
    }

    private Node getByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node node = first;
        while (node != null) {
            if (index == counter) {
                return node;
            }
            counter++;
            node = node.getNext();
        }
        throw new RuntimeException();
    }
}
