package ru.eqour.lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Example4 {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        Random random = new Random();

        System.out.println("\nСписок до\n");

        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(10));
            System.out.print(integers.get(i) + " ");
        }
        System.out.println();

        List<Integer> integersAfter = squareList(integers);

        System.out.println("\nСписок после возведения в квадрат\n");

        for (Integer i : integersAfter) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static List<Integer> squareList(List<Integer> list) {
        return list.stream().map(x -> x * x).collect(Collectors.toList());
    }
}
