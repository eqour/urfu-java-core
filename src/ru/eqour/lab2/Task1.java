package ru.eqour.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task1 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[30];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(20);
        }

        System.out.println(Arrays.toString(numbers));

        List<Integer> indices = findMinNumberIndices(numbers);

        if (indices.isEmpty()) {
            System.out.println("Массив пуст");
        } else {
            System.out.println("Минимальное значение: " + numbers[indices.get(0)]);
            System.out.println("Индексы элементов с минимальным значением: " + indices);
        }
    }

    private static List<Integer> findMinNumberIndices(final int[] numbers) {
        if (numbers.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int min = numbers[0];
        for (int number : numbers) {
            min = Math.min(min, number);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == min) {
                result.add(i);
            }
        }
        return result;
    }
}
