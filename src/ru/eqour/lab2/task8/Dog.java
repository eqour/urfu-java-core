package ru.eqour.lab2.task8;

public class Dog extends Animal {

    public enum Breed {
        POODLE, GERMAN_SHEPHERD, DALMATIAN
    }

    private Breed breed;

    public Dog(String name, int age, Breed breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Гав!");
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }
}
