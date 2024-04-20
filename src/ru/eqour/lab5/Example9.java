package ru.eqour.lab5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example9 {

    public static void main(String[] args) {
        System.out.println(filterOnlyLetters(Arrays.asList("1 буква", "ягода", "какой-нибудь", "java", "regex101")));
    }

    private static List<String> filterOnlyLetters(List<String> stringList) {
        return stringList.stream()
                .filter(s -> s.matches("^[A-zА-яЕеЁё]*$"))
                .collect(Collectors.toList());
    }
}
