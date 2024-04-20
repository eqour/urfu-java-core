package ru.eqour.lab5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example7 {

    public static void main(String[] args) {
        System.out.println(filterByLength(Arrays.asList("озеро", "йод", "атмосфера"), 5));
    }

    private static List<String> filterByLength(List<String> stringList, int maxLength) {
        return stringList.stream()
                .filter(s -> s.length() <= maxLength)
                .collect(Collectors.toList());
    }
}
