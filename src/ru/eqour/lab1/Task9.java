package ru.eqour.lab1;

import java.util.Scanner;

public class Task9 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = in.nextInt();

        System.out.println((number - 1) + " " + number + " " + (number + 1) + " " + ((number * 2) * (number * 2)));
    }
}
