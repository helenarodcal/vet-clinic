package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {

    //    private String name;
//    private String breed;
//    private LocalDateTime dateOfBirth;
    private final String name;
    private final String breed;
    private final LocalDateTime dateOfBirth;
    private final String colour;
    private final String favouriteFood;
    private final String toy;

    public Dog(String name, String breed, LocalDateTime dateOfBirth, String colour, String favouriteFood, String toy) {
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.colour = colour;
        this.favouriteFood = favouriteFood;
        this.toy = toy;
    }


//    public static DogBuilder called(String name) {
//        return new DogBuilder(name);
//    }

    /*
    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    */

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public String getColour() {
        return colour;
    }

    public String getFavouriteToy() {
        return toy;
    }

    interface OfBreed {
        OfColour ofBreed(String breed);
    }
    interface OfColour {
        DogBuilder ofColour(String colour);
    }

    public static OfBreed called(String name) {
        return new DogBuilder(name);
    }

    public static class DogBuilder implements OfBreed, OfColour {
        private String name;
        private String breed;
        private String colour;
        private String favouriteFood;
        private String toy;

        public DogBuilder(String name) {
            this.name = name;
        }
        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDateTime birthday) {
            return new Dog(name, breed, birthday, colour, favouriteFood, toy);
        }

        public DogBuilder ofColour(String colour) {
            this.colour = colour;
            return this;
        }

        public DogBuilder withFavouriteFood(String food) {
            this.favouriteFood = food;
            return this;
        }

        public DogBuilder withFavouriteToy(String toy) {
            this.toy = toy;
            return this;
        }
    }
}

