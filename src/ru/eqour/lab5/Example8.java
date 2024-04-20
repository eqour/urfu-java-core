package ru.eqour.lab5;

import java.util.List;
import java.util.stream.Collectors;

public class Example8 {

    public static void main(String[] args) {
        List<Integer> integers = Utils.generateRandomIntegers(10, 30);
        System.out.println(integers);
        System.out.println(filterGreaterThan(integers, 15));
    }

    private static List<Integer> filterGreaterThan(List<Integer> integers, int minValue) {
        return integers.stream()
                .filter(i -> i > minValue)
                .collect(Collectors.toList());
    }
}
