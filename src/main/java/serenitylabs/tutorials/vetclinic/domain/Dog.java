package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {

    //    private String name;
//    private String breed;
//    private LocalDateTime dateOfBirth;
    private final String name;
    private final String breed;
    private final LocalDateTime dateOfBirth;
    public final String favouriteFood;

    public Dog(String name, String breed, LocalDateTime dateOfBirth) {
//        this.name = name;
//        this.breed = breed;
//        this.dateOfBirth = dateOfBirth;
//        this.favouriteFood = null;
        this(name, breed, dateOfBirth, null);
    }

    public Dog(String name, String breed, LocalDateTime dateOfBirth, String getFavouriteFood) {
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.favouriteFood = getFavouriteFood;
    }

    public static DogBuilder called(String name) {
        return new DogBuilder(name);
    }

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


    public static class DogBuilder {
        private String name;
        private String breed;
//        private LocalDateTime birthday;

        public DogBuilder(String name) {
            this.name = name;
        }
        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }
//        public DogBuilder bornOn(LocalDateTime birthday) {
//            this.birthday = birthday;
//            return this;
//        }
//        public Dog build() {
//            return new Dog(name, breed, birthday);
//        }
        public Dog bornOn(LocalDateTime birthday) {
            return new Dog(name, breed, birthday);
        }

    }
}

