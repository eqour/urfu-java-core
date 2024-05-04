package ru.eqour.lab6;

import java.util.ArrayList;
import java.util.List;

public class Example4 {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final int number = i;
            threads.add(new Thread(() -> System.out.println(Thread.currentThread().getName() + ": " + number)));
        }

        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
