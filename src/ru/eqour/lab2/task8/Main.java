package ru.eqour.lab2.task8;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Снежок", 3, Cat.FoodType.HOLISTIC);
        Dog dog = new Dog("Арчи", 7, Dog.Breed.POODLE);
        Bird bird = new Bird("Чижик-пыжик", 13, 400);
        System.out.println(cat.foodType);
        System.out.println(dog.getBreed());
        System.out.println(bird.getFlightAltitudeInMeters());
        cat.makeSound();
        dog.makeSound();
        bird.makeSound();
    }
}
