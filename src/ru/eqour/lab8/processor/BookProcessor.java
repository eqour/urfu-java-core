package ru.eqour.lab8.processor;

import ru.eqour.lab8.Book;

import java.io.FileNotFoundException;
import java.util.List;

public interface BookProcessor {
    List<Book> read() throws FileNotFoundException;
    void write(List<Book> books);
}
