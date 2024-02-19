package ru.eqour.timus;

import java.util.Scanner;

public class Task2066 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if (a == 0 && b == 1 || a == 1 && b == 1 || b == 0 || c == 0) {
            System.out.println(a - b - c);
        } else {
            System.out.println(a - b * c);
        }
    }
}
