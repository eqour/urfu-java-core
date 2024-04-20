package ru.eqour.lab5;

import java.util.List;
import java.util.stream.Collectors;

public class Example10 {

    public static void main(String[] args) {
        List<Integer> integers = Utils.generateRandomIntegers(10, 30);
        System.out.println(integers);
        System.out.println(filterLessThan(integers, 15));
    }

    private static List<Integer> filterLessThan(List<Integer> integers, int maxValue) {
        return integers.stream()
                .filter(i -> i < maxValue)
                .collect(Collectors.toList());
    }
}
