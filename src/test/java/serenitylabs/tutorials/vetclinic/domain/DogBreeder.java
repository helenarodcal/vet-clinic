package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class DogBreeder implements OfBreed, OfColour {
    private String name;
    private String breed;
    private String colour;
    private String favouriteFood;
    private String toy;

    public static DogBreeder aDog() {
        return new DogBreeder();
    }

    //PROTOTYPE METHODS
    public static DogBreeder aLargeDog() {
        return aDog().ofBreed("Labrador");
    }

    public static DogBreeder aSmallDog() {
        return aDog().ofBreed("Poodle");
    }

    public static DogBreeder aGuardDog() {
        return aDog().ofBreed("German Shepard");
    }

    public DogBreeder called(String name) {
        this.name = name;
        return this;

    }

    public DogBreeder ofBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public Dog bornOn(LocalDateTime birthday) {
        return new Dog(name, breed, birthday, colour, favouriteFood, toy);
    }

    public DogBreeder ofColour(String colour) {
        this.colour = colour;
        return this;
    }

    public DogBreeder withFavouriteFood(String food) {
        this.favouriteFood = food;
        return this;
    }

    public DogBreeder withFavouriteToy(String toy) {
        this.toy = toy;
        return this;
    }
}

