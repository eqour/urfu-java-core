package ru.eqour.lab1;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = in.next();

        System.out.print("Введите возраст: ");
        int age = in.nextInt();

        System.out.println("Имя: " + name + ", возраст: " + age);
    }
}
