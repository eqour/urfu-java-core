package ru.eqour.lab2.task6and9;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5.5));
        shapes.add(new Square(37));
        shapes.add(new Triangle(1, 1, 2, 6, -3, 5));
        printShapes(shapes);
    }

    private static void printShapes(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println("Фигура: " + shape.getName() + ", периметр: " + shape.calcPerimeter() + ", площадь: " + shape.calcArea());
        }
    }
}
