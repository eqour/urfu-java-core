package ru.eqour.lab7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example7 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String path = scanner.nextLine();
        System.out.print("Введите строку для записи: ");
        String text = scanner.nextLine();
        FileWriter writer = new FileWriter(path);
        writer.write(text);
        writer.close();
        System.out.println("В файл записано " + text.length() + " символов");
    }
}
