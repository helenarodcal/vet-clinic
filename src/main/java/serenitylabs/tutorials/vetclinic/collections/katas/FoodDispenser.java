package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;

import java.util.HashMap;
import java.util.Map;

public class FoodDispenser {
    private static final Map<Breed, Integer> GRAMS_OF_FOOD_PER_KILO = new HashMap<>();
    private static final Map<Breed, PetFood> BRAND_OF_FOOD = new HashMap<>();

    static {
        GRAMS_OF_FOOD_PER_KILO.put(Breed.Cat, 10);
        GRAMS_OF_FOOD_PER_KILO.put(Breed.Dog, 20);
    }

    static {
        BRAND_OF_FOOD.put(Breed.Cat, PetFood.KittyKat);
        BRAND_OF_FOOD.put(Breed.Dog, PetFood.FidosFood);
    }

    public Meal prepareMealFor(Pet pet) {
        return new Meal(rightAmountOfFoodFor(pet), rightFoodTypeFor(pet));
    }


    private PetFood rightFoodTypeFor(Pet pet) {
        return BRAND_OF_FOOD.get(pet.getBreed());
    }

    private double rightAmountOfFoodFor(Pet pet) {
        return GRAMS_OF_FOOD_PER_KILO.get(pet.getBreed()) * pet.getWeightInKilos();
    }
}
