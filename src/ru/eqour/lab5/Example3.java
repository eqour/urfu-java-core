package ru.eqour.lab5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example3 {

    public static void main(String[] args) {
        String string = "Напишите функцию, которая принимает на вход список строк.";
        List<String> strings = Arrays.asList(string.split(" "));
        System.out.println("\n" + "Строка после сплитования : " + "\n");
        for (String s : strings) {
            System.out.println(s);
        }

        List<String> stringsAfter = filterCapitalizedStrings(strings);

        System.out.println("\n" + "Строка после преобразования :" + "\n");
        for (String s : stringsAfter) {
            System.out.println(s);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> strings) {
        return strings.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}
