package ru.eqour.lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Example6 {

    public static void main(String[] args) throws InterruptedException {
        int processors = Runtime.getRuntime().availableProcessors();
        int[] numbers = generateNumbersArray(100);
        System.out.println("Сумма без многопоточности: " + Arrays.stream(numbers).sum());
        System.out.println("Сумма с многопоточностью: " + sum(numbers, processors));
    }

    private static int[] generateNumbersArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    private static int sum(int[] numbers, int threadCount) throws InterruptedException {
        final int numbersForThread = numbers.length < threadCount ? 1 : numbers.length / threadCount;
        if (threadCount > numbers.length) {
            threadCount = numbers.length;
        }
        final int threadNumber = threadCount;
        int[] sum = new int[1];
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            threads.add(new Thread(() -> {
                for (int j = numbersForThread * index; j < numbers.length && (j < numbersForThread * (index + 1) || index == threadNumber - 1); j++) {
                    synchronized (sum) {
                        sum[0] += numbers[j];
                    }
                }
            }));
        }
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        return sum[0];
    }
}
