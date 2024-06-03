package ru.eqour.lab8.processor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import ru.eqour.lab8.Book;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonBookProcessor implements BookProcessor {

    private final String path;

    public JsonBookProcessor(String path) {
        this.path = path;
    }

    @Override
    public List<Book> read() throws FileNotFoundException {
        List<Book> books = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            for (Object o : jsonArray) {
                JSONObject book = (JSONObject) o;
                books.add(
                        new Book(
                                book.get("title").toString(),
                                book.get("author").toString(),
                                Integer.parseInt(book.get("year").toString()
                                )
                        )
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public void write(List<Book> books) {
        JSONObject library = new JSONObject();
        JSONArray booksArray = new JSONArray();

        for (Book book : books) {
            JSONObject jsonBook = new JSONObject();
            jsonBook.put("title", book.getTitle());
            jsonBook.put("author", book.getAuthor());
            jsonBook.put("year", book.getYear());
            booksArray.add(jsonBook);
        }

        library.put("books", booksArray);

        try (FileWriter file = new FileWriter(path)) {
            file.write(library.toJSONString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
