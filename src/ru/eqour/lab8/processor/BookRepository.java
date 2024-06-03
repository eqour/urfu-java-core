package ru.eqour.lab8.processor;

import ru.eqour.lab8.Book;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {

    private final BookProcessor processor;

    public BookRepository(BookProcessor processor) {
        this.processor = processor;
    }

    public List<Book> findAll() {
        return getBooks();
    }

    public List<Book> findByAuthor(String author) {
        List<Book> books = getBooks();
        return books.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    public void add(Book book) {
        List<Book> books = getBooks();
        books.add(book);
        processor.write(books);
    }

    public void removeByTitle(String title) {
        List<Book> books = getBooks();
        books.removeIf(book -> book.getTitle().equals(title));
        processor.write(books);
    }

    private List<Book> getBooks() {
        try {
            return processor.read();
        } catch (FileNotFoundException ignore) {
            return new ArrayList<>();
        }
    }
}
