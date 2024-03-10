package ru.eqour.lab2.task6and9;

public abstract class AbstractShape implements Shape {

    private String name;

    public AbstractShape(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
