package ru.eqour.lab1;

import java.util.Calendar;
import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите ваш год рождения: ");
        int birthYear = in.nextInt();

        int age = calcAge(birthYear);
        if (age < 0) {
            System.out.println("Вы ещё не родились :)");
        } else {
            System.out.println("Ваш возраст (лет): " + age);
        }
    }

    private static int calcAge(int birthYear) {
        return Calendar.getInstance().get(Calendar.YEAR) - birthYear;
    }
}
