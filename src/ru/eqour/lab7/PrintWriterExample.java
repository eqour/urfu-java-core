package ru.eqour.lab7;

import java.io.*;

public class PrintWriterExample {

    public static void main(String[] args) {
        String inputFileName = "C:/test/in.txt";
        String outputFileName = "C:/test/out.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
             PrintWriter printWriter = new PrintWriter(outputFileName, "UTF-8")) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.println(line.toUpperCase());
            }
            printWriter.flush();
            System.out.println("Данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
