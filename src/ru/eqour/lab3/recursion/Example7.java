package ru.eqour.lab3.recursion;

import java.util.Scanner;

public class Example7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = in.nextInt();
        int[] array = new int[size];
        inputArray(array, in);
        printArray(array);
    }

    private static void inputArray(int[] array, Scanner in) {
        inputArray(array, in, 0);
    }

    private static void inputArray(int[] array, Scanner in, int index) {
        if (index >= array.length) {
            return;
        }
        System.out.print("Введите array[" + index + "]: ");
        array[index] = in.nextInt();
        inputArray(array, in, index + 1);
    }

    private static void printArray(int[] array) {
        printArray(array, 0);
    }

    private static void printArray(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        System.out.println(array[index]);
        printArray(array, index + 1);
    }
}
