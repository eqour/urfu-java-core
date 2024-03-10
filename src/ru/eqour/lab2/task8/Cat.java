package ru.eqour.lab2.task8;

public class Cat extends Animal {

    public enum FoodType {
        ECONOMY, PREMIUM, HOLISTIC
    }

    FoodType foodType;

    public Cat(String name, int age, FoodType foodType) {
        super(name, age);
        this.foodType = foodType;
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }
}
