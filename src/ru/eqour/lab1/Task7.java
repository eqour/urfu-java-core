package ru.eqour.lab1;

import java.util.Calendar;
import java.util.Scanner;

public class Task7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Сколько лет вам исполняется в этом году? ");
        int age = in.nextInt();

        System.out.println("Вы родились в " + calcBirthYear(age) + " году");
    }

    private static int calcBirthYear(int age) {
        return Calendar.getInstance().get(Calendar.YEAR) - age;
    }
}
