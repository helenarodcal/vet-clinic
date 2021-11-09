package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {

    private final String name;
    private final String breed;
    private final String colour;
    private final LocalDateTime birthdate;
    private final String favouriteFood;

    private Dog(String name, String breed, String colour, LocalDateTime birthdate, String favouriteFood) {
        this.name = name;
        this.breed = breed;
        this.colour = colour;
        this.birthdate = birthdate;
        this.favouriteFood = favouriteFood;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    public String getBreed() {
        return breed;
    }

    public String getColour() {
        return colour;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }
//    public static DogBuilder called(String name) {
//        return new DogBuilder(name);
//    }


//making ofBreed and ofColour mandatory

    public static WithBreed called(String name) {
        return new DogBuilder(name);
    }

    interface WithBreed {
        OfColour ofBreed(String breed);
    }
    interface OfColour {
        DogBuilder ofColour(String colour);
    }

    public static class DogBuilder implements WithBreed, OfColour{
        private String name;
        private String breed;
        private String favouriteFood;
        private String colour;

        public DogBuilder(String name) {
            this.name = name;
        }
        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDateTime dateOfBirth){
            return new Dog(name, breed, colour, dateOfBirth, favouriteFood);
        }

        public DogBuilder withFavouriteFood(String favouriteFood) {
            this.favouriteFood = favouriteFood;
            return this;
        }

        public DogBuilder ofColour(String colour) {
            this.colour = colour;
            return this;
        }
    }
}
