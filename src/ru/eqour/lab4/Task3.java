package ru.eqour.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Данная программа вычисляет сумму чисел типа byte.");
        System.out.println("Для расчёта введите числа через пробел одной строкой:");
        String input = scanner.nextLine();

        try {
            int result = calcSum(parseNumbersString(input));
            System.out.println("Сумма чисел: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: одно из чисел имеет неверный формат (" + e.getMessage() + ")");
        }
    }

    private static List<Byte> parseNumbersString(String numbersString) {
        String[] textNumbers = numbersString.split(" +");
        List<Byte> result = new ArrayList<>();
        for (String textNumber : textNumbers) {
            result.add(Byte.parseByte(textNumber));
        }
        return result;
    }

    private static int calcSum(List<Byte> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
