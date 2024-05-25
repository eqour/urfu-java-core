package ru.eqour.lab7;

import java.io.*;
import java.util.Arrays;

public class Example8 {

    public static void main(String[] args) {
        Settings settings = new Settings("C:/test/123.txt", 5, Arrays.asList(10, 2024, 5, 304, 6));

        try {
            FileOutputStream fileOut = new FileOutputStream("C:/test/settings.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(settings);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileIn = new FileInputStream("C:/test/settings.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Settings s = (Settings) in.readObject();
            in.close();
            fileIn.close();
            System.out.println(s);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
