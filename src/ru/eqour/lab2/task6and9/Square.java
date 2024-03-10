package ru.eqour.lab2.task6and9;

public class Square extends AbstractShape {

    private double size;

    public Square() {
        super("Квадрат");
    }

    public Square(int size) {
        this();
        this.size = size;
    }

    @Override
    public double calcPerimeter() {
        return size * 4;
    }

    @Override
    public double calcArea() {
        return size * size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
