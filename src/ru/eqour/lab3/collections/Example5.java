package ru.eqour.lab3.collections;

public class Example5 {

    public static void main(String[] args) {
        System.out.println(MyLinkedList.createHead());
        System.out.println(MyLinkedList.createTail());
        System.out.println(MyLinkedList.createHeadRec());
        System.out.println(MyLinkedList.createTailRec());
        MyLinkedList list = new MyLinkedList();
        list.addLast(5);
        list.removeFirst();
        list.addFirst(5);
        list.removeLast();
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(5);
        list.insert(1, 6);
        list.remove(1);
        System.out.println(list.toStringRec());
    }
}
