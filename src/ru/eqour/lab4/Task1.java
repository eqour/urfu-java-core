package ru.eqour.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Данная программа вычисляет среднее значение среди положительных чисел.");
        System.out.println("Для расчёта введите числа через пробел одной строкой:");
        String input = scanner.nextLine();

        try {
            double result = calcPositiveNumbersAverage(parseNumbersString(input));
            System.out.printf("Среднее значение среди положительных чисел: %.2f %n", result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: одно из чисел имеет неверный формат (" + e.getMessage() + ")");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: во входных данных отсутствуют положительные числа");
        }
    }

    private static List<Integer> parseNumbersString(String numbersString) {
        String[] textNumbers = numbersString.split(" +");
        List<Integer> result = new ArrayList<>();
        for (String textNumber : textNumbers) {
            result.add(Integer.parseInt(textNumber));
        }
        return result;
    }

    private static double calcPositiveNumbersAverage(List<Integer> numbers) {
        int sum = 0;
        int count = 0;
        for (int number : numbers) {
            if (number > 0) {
                sum += number;
                count++;
            }
        }
        if (count == 0) {
            throw new ArithmeticException("Деление на 0");
        }
        return sum / (double) count;
    }
}
