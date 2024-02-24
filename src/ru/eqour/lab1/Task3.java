package ru.eqour.lab1;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите название текущего дня недели: ");
        String dayOfWeek = in.next();

        System.out.print("Введите название месяца: ");
        String month = in.next();

        System.out.print("Введите текущий день месяца: ");
        int day = in.nextInt();

        System.out.println("Сегодня " + dayOfWeek + ", " + day + " число, " + month);
    }
}
