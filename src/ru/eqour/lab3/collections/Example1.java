package ru.eqour.lab3.collections;

import java.util.*;

public class Example1 {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, String.valueOf(i * i * i * i * i * 5));
        }
        int[] keyProduct = new int[]{1};
        List<String> stringList = new ArrayList<>();
        map.forEach((key, value) -> {
            if (key == 0) {
                System.out.println(value);
            }
            if (key > 5) {
                stringList.add(value);
            }
            if (value.length() > 5) {
                keyProduct[0] *= key;
            }
        });
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println(keyProduct[0]);
    }
}
