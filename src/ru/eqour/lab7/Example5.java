package ru.eqour.lab7;

import java.io.File;
import java.util.Scanner;

public class Example5 {

    public static void main(String[] args) {
        System.out.print("Введите путь к файлу: ");
        String path = new Scanner(System.in).next();
        File file = new File(path);
        if (file.exists()) {
            System.out.println("Размер файла в байтах: " + file.length());
        } else {
            System.out.println("Такого файла не существует");
        }
    }
}
