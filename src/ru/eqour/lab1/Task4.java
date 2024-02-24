package ru.eqour.lab1;

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите название месяца: ");
        String month = in.next();

        System.out.print("Введите количество дней в месяце: ");
        int daysInMonth = in.nextInt();

        System.out.println("Месяц " + month + " содержит дней: " + daysInMonth);
    }
}
