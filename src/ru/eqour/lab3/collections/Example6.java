package ru.eqour.lab3.collections;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Example6 {

    public static void main(String[] args) {
        System.out.println("Добавление в начало коллекции:");
        testCollectionOperation(new ArrayList<>(), c -> c.add(0, 0), ArrayList::add);
        testCollectionOperation(new TreeSet<>(), c -> c.add(-5), TreeSet::add);
        testCollectionOperation(new LinkedHashMap<>(), c -> c.put(-5, -5), (c, v) -> c.put(v, v));
        System.out.println("Добавление в конец коллекции:");
        testCollectionOperation(new ArrayList<>(), c -> c.add(c.size(), 0), ArrayList::add);
        testCollectionOperation(new TreeSet<>(), c -> c.add(5_000_000), TreeSet::add);
        testCollectionOperation(new LinkedHashMap<>(), c -> c.put(5_000_000, 5_000_000), (c, v) -> c.put(v, v));
        System.out.println("Добавление в середину коллекции:");
        testCollectionOperation(new ArrayList<>(), c -> c.add(c.size() / 2, 0), ArrayList::add);
        testCollectionOperation(new TreeSet<>(), c -> c.add(2_000_000), TreeSet::add);
        testCollectionOperation(new LinkedHashMap<>(), c -> c.put(2_000_000, 2_000_000), (c, v) -> c.put(v, v));
        System.out.println("Удаление в начале коллекции:");
        testCollectionOperation(new ArrayList<>(), c -> c.remove(0), ArrayList::add);
        testCollectionOperation(new TreeSet<>(), c -> c.remove(0), TreeSet::add);
        testCollectionOperation(new LinkedHashMap<>(), c -> c.remove(0), (c, v) -> c.put(v, v));
        System.out.println("Удаление в конце коллекции:");
        testCollectionOperation(new ArrayList<>(), c -> c.remove(c.size() - 1), ArrayList::add);
        testCollectionOperation(new TreeSet<>(), c -> c.remove(3_999_999), TreeSet::add);
        testCollectionOperation(new LinkedHashMap<>(), c -> c.remove(3_999_999), (c, v) -> c.put(v, v));
        System.out.println("Удаление в середине коллекции:");
        testCollectionOperation(new ArrayList<>(), c -> c.remove(c.size() / 2), ArrayList::add);
        testCollectionOperation(new TreeSet<>(), c -> c.remove(2_000_000), TreeSet::add);
        testCollectionOperation(new LinkedHashMap<>(), c -> c.remove(2_000_000), (c, v) -> c.put(v, v));
        System.out.println("Получение элемента по индексу:");
        testCollectionOperation(new ArrayList<>(), c -> c.get(c.size() / 2), ArrayList::add);
        testCollectionOperation(new LinkedHashMap<>(), c -> c.get(2_000_000), (c, v) -> c.put(v, v));
    }

    private static <T> void testCollectionOperation(T collection, Consumer<T> action, BiConsumer<T, Number> addAction) {
        for (int i = 0; i < 4_000_000; i++) {
            addAction.accept(collection, i);
        }
        long start = System.nanoTime();
        action.accept(collection);
        long end = System.nanoTime();
        System.out.println("Время: " + (end - start) + " нс.");
    }
}
