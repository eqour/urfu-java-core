package ru.eqour.lab3.collections;

import java.util.*;
import java.util.function.Function;

public class Example2 {

    public static void main(String[] args) {
        System.out.println("Алгоритм 1, ArrayList: ");
        executeWithTime(new ArrayList<>(), Example2::removePeoples1);
        System.out.println("Алгоритм 1, LinkedList: ");
        executeWithTime(new LinkedList<>(), Example2::removePeoples1);
        System.out.println("Алгоритм 2, ArrayList: ");
        executeWithTime(new ArrayList<>(), Example2::removePeoples2);
        System.out.println("Алгоритм 2, LinkedList: ");
        executeWithTime(new LinkedList<>(), Example2::removePeoples2);
    }

    private static void executeWithTime(List<Integer> list, Function<List<Integer>, Integer> algorithm) {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        long start = System.nanoTime();
        int last = algorithm.apply(list);
        long end = System.nanoTime();
        System.out.println("Оставшийся индекс: " + last + "; время: " + (end - start) + " нс.");
    }

    private static int removePeoples1(List<Integer> peoples) {
        int size = peoples.size();
        boolean removeNext = false;
        int index = 0;
        while (size > 1) {
            if (peoples.get(index) >= 0) {
                if (removeNext) {
                    peoples.set(index, -1);
                    size--;
                }
                removeNext = !removeNext;
            }
            index++;
            if (index >= peoples.size()) {
                index = 0;
            }
        }
        for (int i = 0; i < peoples.size(); i++) {
            if (peoples.get(i) >= 0) {
                return i;
            }
        }
        return 0;
    }

    private static int removePeoples2(List<Integer> peoples) {
        boolean removeNext = false;
        while (peoples.size() > 1) {
            ListIterator<Integer> iterator = peoples.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (removeNext) {
                    iterator.remove();
                }
                removeNext = !removeNext;
            }
        }
        return peoples.get(0);
    }
}
