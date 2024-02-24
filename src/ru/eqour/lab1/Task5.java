package ru.eqour.lab1;

import java.util.Calendar;

public class Task5 {

    public static void main(String[] args) {
        System.out.println(calcAge(2020));
    }

    private static int calcAge(int birthYear) {
        return Calendar.getInstance().get(Calendar.YEAR) - birthYear;
    }
}
