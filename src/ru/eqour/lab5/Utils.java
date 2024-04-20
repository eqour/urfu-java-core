package ru.eqour.lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

    public static List<Integer> generateRandomIntegers(int size, int bound) {
        Random random = new Random();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            integers.add(random.nextInt(bound));
        }
        return integers;
    }
}
