package ru.eqour.lab8;

import ru.eqour.lab8.processor.BookRepository;
import ru.eqour.lab8.processor.JsonBookProcessor;
import ru.eqour.lab8.processor.XmlBookProcessor;

import java.util.Arrays;
import java.util.List;

public class Example9 {

    public static void main(String[] args) {
        testProcessor(new BookRepository(new XmlBookProcessor("src/ru/eqour/lab8/example9.xml")));
        //testProcessor(new BookRepository(new JsonBookProcessor("src/ru/eqour/lab8/example9.json")));
    }

    private static void testProcessor(BookRepository bookRepository) {
        getBooks().forEach(bookRepository::add);
        bookRepository.findAll().forEach(book -> System.out.println(book.toString()));
        System.out.println();
        bookRepository.findByAuthor("Лев Толстой").forEach(book -> System.out.println(book.toString()));
        System.out.println();
        bookRepository.findAll().forEach(book -> System.out.println(book.toString()));
        System.out.println();
        bookRepository.removeByTitle("Мастер и Маргарита");
        bookRepository.findAll().forEach(book -> System.out.println(book.toString()));
    }

    private static List<Book> getBooks() {
        return Arrays.asList(
                new Book("Война и мир", "Лев Толстой", 1869),
                new Book("Мастер и Маргарита", "Михаил Булгаков", 1967),
                new Book("Анна Каренина", "Лев Толстой", 1873)
        );
    }
}
