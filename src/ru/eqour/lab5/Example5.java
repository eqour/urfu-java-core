package ru.eqour.lab5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example5 {

    public static void main(String[] args) {
        System.out.println(filterHasSubstring(Arrays.asList("гороскоп", "горе", "озеро", "гора", "яма"), "гор"));
    }

    private static List<String> filterHasSubstring(List<String> stringList, String substring) {
        return stringList.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}
