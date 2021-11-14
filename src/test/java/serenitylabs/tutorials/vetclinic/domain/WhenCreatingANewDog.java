package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenCreatingANewDog {
    LocalDateTime birthday = LocalDateTime.now();


    @Test
    public void it_should_have_a_name_breed_colour_and_date_of_birth() {
//        Dog fido = Dog.called("Fido")
//                .ofBreed("Poodle")
//                .ofColour("black")
//                .bornOn(birthday);

        //separating the builder from the domain class
//        Dog fido = DogBreeder.aDog()
//                .called("Fido")
//                .ofBreed("Poodle")
//                .ofColour("black")
//                .bornOn(birthday);
        //PROTOTYPING -- builder with some pre-populated data
                Dog fido = DogBreeder.aLargeDog()
                .called("Fido")
                .ofColour("black")
                .bornOn(birthday);
        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("black", fido.getColour());
        Assert.assertEquals(birthday, fido.getDateOfBirth());
    }

    @Test
    public void it_can_have_an_optional_favourite_food() {
        Dog bobby = DogBreeder.aGuardDog()
                .called("Bobby")
                .ofColour("Black")
                .withFavouriteFood("meat")
                .bornOn(birthday);
        Assert.assertEquals("German Shepard", bobby.getBreed());
        Assert.assertEquals("meat", bobby.getFavouriteFood());

        //PROTOTYPE
        Dog rita = DogBreeder.aSmallDog()
                .called("Rita")
                .ofColour("White")
                .bornOn(birthday);
        Assert.assertEquals("Poodle", rita.getBreed());
        Assert.assertNull(rita.getFavouriteFood());
    }

    @Test
    public void it_can_have_an_optional_favourite_toy() {
        Dog jewel = DogBreeder.aDog()
                .called("Jewel")
                .ofBreed("Labrador")
                .ofColour("Golden")
                .withFavouriteToy("bone")
                .bornOn(birthday);
        Assert.assertEquals("bone", jewel.getFavouriteToy());

        Dog lance = DogBreeder.aDog()
                .called("Lance")
                .ofBreed("Labrador")
                .ofColour("Black")
                .bornOn(birthday);
        Assert.assertNull(lance.getFavouriteToy());
    }
}
