package ru.eqour.lab8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Example10 {

    public static void main(String[] args) {
        try {
            Document doc = tryGet("http://fat.urfu.ru/index.html");

            Elements newsParent = doc.select("body > table > tbody > tr > td > div > table > " +
                    "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > " +
                    "tr > td:nth-child(1)");

            List<String> lines = new ArrayList<>();

            for (int i = 3; i < 20; i++) {
                if (!(i % 2 == 0)) {
                    List<Node> nodes = newsParent.get(0).childNodes();
                    String l1 = "Тема: " + ((Element) nodes.get(i)).getElementsByClass("blocktitle").get(0).childNodes().get(0);
                    String l2 = "Дата: " + ((Element) nodes.get(i)).getElementsByClass("blockdate").get(0).childNodes().get(0) + "\n";
                    lines.add(l1);
                    lines.add(l2);
                    System.out.println(l1);
                    System.out.println(l2);
                }
            }

            try (FileWriter writer = new FileWriter("src/ru/eqour/lab8/example10.txt", false)) {
                for (String line : lines) {
                    writer.write(line);
                }
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            System.out.println("При загрузке произошла ошибка: " + e.getLocalizedMessage());
        }
    }

    private static Document tryGet(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException ignored) {
            System.out.println("Ошибка загрузки страницы, повторное подключение...");
        }
        if (document == null) {
            try {
                return Jsoup.connect(url).get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return document;
    }
}
