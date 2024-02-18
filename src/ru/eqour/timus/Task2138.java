package ru.eqour.timus;

import java.util.Scanner;

public class Task2138 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        long number = in.nextLong();
        System.out.println(convert(number));
    }

    private static long convert(long number) {
        byte[] bytes = {
                (byte) (number & 0x000000FF),
                (byte) ((number >> 8) & 0x000000FF),
                (byte) ((number >> 16) & 0x000000FF),
                (byte) ((number >> 24) & 0x000000FF),
        };
        long result = 0;
        result = result | (Byte.toUnsignedLong(bytes[0]) << 24);
        result = result | (Byte.toUnsignedLong(bytes[1]) << 16);
        result = result | (Byte.toUnsignedLong(bytes[2]) << 8);
        result = result | Byte.toUnsignedLong(bytes[3]);
        return result;
    }
}
