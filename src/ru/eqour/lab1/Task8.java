package ru.eqour.lab1;

import java.util.Scanner;

public class Task8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = in.nextInt();

        System.out.print("Введите второе число: ");
        int b = in.nextInt();

        System.out.println(a + " + " + b + " = " + (a + b));
    }
}
