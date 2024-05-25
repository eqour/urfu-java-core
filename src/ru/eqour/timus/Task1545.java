package ru.eqour.timus;

import java.util.Scanner;

public class Task1545 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] values = new String[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.next();
        }
        String start = scanner.next();
        for (int i = 0; i < n; i++) {
            if (values[i].startsWith(start)) {
                System.out.println(values[i]);
            }
        }
    }
}
