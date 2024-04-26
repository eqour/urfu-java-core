package ru.eqour.timus;

import java.util.Scanner;

public class Task1787 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int r = 0;
        for (int i = 0; i < n; i++) {
            r += scanner.nextInt();
            r = Math.max(0, r - k);
        }
        System.out.println(r);
    }
}
