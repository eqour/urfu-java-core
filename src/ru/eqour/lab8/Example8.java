package ru.eqour.lab8;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class Example8 {

    public static void main(String[] args) {
        try {
            String filePath = "src/ru/eqour/lab8/example3.xlsx";
            FileInputStream inputStream = new FileInputStream(filePath);

            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workbook.getSheet("Товары");

            if (sheet == null) {
                System.out.println("Лист с именем \"Товары\" отсутствует");
                return;
            }

            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.println(cell.toString() + "\t");
                }
                System.out.println();
            }

            workbook.close();
            inputStream.close();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getLocalizedMessage());
        }
    }
}
