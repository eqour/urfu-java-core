package ru.eqour.lab3.recursion;

public class Example6 {

    public static void main(String[] args) {
        printBinary(10);
    }

    private static void printBinary(int n) {
        int remainder = n % 2;
        if (n > 1) {
            printBinary(n / 2);
        }
        System.out.print(remainder);
    }
}
