package ru.eqour.lab2;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите текст для шифрования: ");
        String text = in.nextLine();
        System.out.print("Введите ключ: ");
        int key = in.nextInt();
        String encodedText = encode(text, key);
        System.out.println("Текст после преобразования: " + encodedText);
        boolean performDecoding = false;
        boolean badAnswer = true;
        do {
            System.out.print("Выполнить обратное преобразование? (y/n): ");
            String answer = in.next();
            if (answer.equals("y")) {
                performDecoding = true;
                badAnswer = false;
            } else if (answer.equals("n")) {
                badAnswer = false;
            }
            if (badAnswer) {
                System.out.println("Введите корректный ответ");
            }
        } while (badAnswer);
        if (performDecoding) {
            System.out.println("Текст после обратного преобразования: " + decode(encodedText, key));
        } else {
            System.out.println("До свидания!");
        }
    }

    private static String decode(String encodedText, int shift) {
        return encode(encodedText, -shift);
    }

    private static String encode(String text, int shift) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            builder.append((char) (((long) text.charAt(i)) + shift));
        }
        return builder.toString();
    }
}
