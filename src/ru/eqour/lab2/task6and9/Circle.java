package ru.eqour.lab2.task6and9;

public class Circle extends AbstractShape {

    double radius;

    public Circle() {
        super("Круг");
    }

    public Circle(double radius) {
        this();
        this.radius = radius;
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
