package ru.eqour.lab4;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = generateRandomMatrix();
        System.out.println("Сгенерирована матрица:\n");
        System.out.println(matrixToString(matrix));
        System.out.print("Введите номер столбца матрицы: ");

        try {
            int column = scanner.nextInt();
            String matrixColumn = matrixColumnToString(matrix, column);
            System.out.println(column + " столбец матрицы:\n");
            System.out.println(matrixColumn);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: нет столбца с таким номером");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: число имеет неверный формат");
        }
    }

    private static int[][] generateRandomMatrix() {
        Random random = new Random();
        int width = random.nextInt(3) + 3;
        int height = random.nextInt(3) + 3;
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }

    private static String matrixToString(int[][] matrix) {
        StringBuilder builder = new StringBuilder();
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                if (j > 0) {
                    builder.append(" ");
                }
                builder.append(row[j]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private static String matrixColumnToString(int[][] matrix, int column) {
        StringBuilder builder = new StringBuilder();
        for (int[] ints : matrix) {
            builder.append(ints[column - 1]).append("\n");
        }
        return builder.toString();
    }
}
