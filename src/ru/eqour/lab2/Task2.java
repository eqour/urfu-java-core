package ru.eqour.lab2;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        int[][] array = createSnakeArray(9);
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] createSnakeArray(int size) {
        int[][] result = new int[size][size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < size; j++) {
                    result[i][j] = counter;
                    counter++;
                }
            } else {
                for (int j = size - 1; j >= 0; j--) {
                    result[i][j] = counter;
                    counter++;
                }
            }
        }
        return result;
    }
}
