package ru.eqour.lab1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter surname: ");
        String surname = in.next();

        System.out.print("Enter name: ");
        String name = in.next();

        System.out.print("Enter patronymic: ");
        String patronymic = in.next();

        System.out.println("Hello, " + surname + " " + name + " " + patronymic);
    }
}
