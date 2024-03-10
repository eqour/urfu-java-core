package ru.eqour.lab2.task8;

public class Bird extends Animal {

    private double flightAltitudeInMeters;

    public Bird(String name, int age, double flightAltitudeInMeters) {
        super(name, age);
        this.flightAltitudeInMeters = flightAltitudeInMeters;
    }

    @Override
    public void makeSound() {
        System.out.println("Чик-чирик!");
    }

    public double getFlightAltitudeInMeters() {
        return flightAltitudeInMeters;
    }

    public void setFlightAltitudeInMeters(double flightAltitudeInMeters) {
        this.flightAltitudeInMeters = flightAltitudeInMeters;
    }
}
