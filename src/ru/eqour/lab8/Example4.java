package ru.eqour.lab8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Example4 {

    public static void main(String[] args) throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/ru/eqour/lab8/example2.json"));
        JSONObject jsonObject = (JSONObject) obj;
        System.out.println("Корневой элемент: " + jsonObject.keySet().iterator().next());
        JSONArray jsonArray = (JSONArray) jsonObject.get("books");

        for (Object o : jsonArray) {
            JSONObject book = (JSONObject) o;
            System.out.println("\nТекущий элемент: book");
            System.out.println("Название книги: " + book.get("title"));
            System.out.println("Автор: " + book.get("author"));
            System.out.println("Год издания: " + book.get("year"));
        }
    }
}
