package ru.eqour.lab5;

import java.util.List;
import java.util.stream.Collectors;

public class Example6 {

    public static void main(String[] args) {
        List<Integer> integers = Utils.generateRandomIntegers(10, 50);
        System.out.println(integers);
        System.out.println(getDividedCompletely(integers, 3));
    }

    private static List<Integer> getDividedCompletely(List<Integer> integers, int divider) {
        return integers.stream()
                .filter(i -> i % divider == 0)
                .collect(Collectors.toList());
    }
}
