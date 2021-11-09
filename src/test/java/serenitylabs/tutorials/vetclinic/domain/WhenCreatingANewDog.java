package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenCreatingANewDog {
    LocalDateTime birthday = LocalDateTime.now();
    Dog fido = Dog.called("Fido")
            .ofBreed("Poodle")
            .ofColour("black")
            .bornOn(birthday);

    @Test
    public void it_should_have_a_name() {
        Assert.assertEquals("Fido", fido.getName());
    }

    @Test
    public void it_should_have_a_breed() {
        Assert.assertEquals("Poodle", fido.getBreed());
    }

    @Test
    public void it_should_have_a_colour() {
        Assert.assertEquals("black", fido.getColour());
    }

    @Test
    public void it_should_have_a_birthday() {
        Assert.assertEquals(birthday, fido.getDateOfBirth());
    }

    @Test
    public void it_can_have_an_optional_favourite_food() {
        Dog bobby = Dog.called("Bobby")
                .ofBreed("Labrador")
                .ofColour("Golden")
                .withFavouriteFood("meat")
                .bornOn(birthday);
        Assert.assertEquals("meat", bobby.getFavouriteFood());

        Dog rita = Dog.called("Rita")
                .ofBreed("Labrador")
                .ofColour("Black")
                .bornOn(birthday);
        Assert.assertNull(rita.getFavouriteFood());
    }

    @Test
    public void it_can_have_an_optional_favourite_toy() {
        Dog jewel = Dog.called("Jewel")
                .ofBreed("Labrador")
                .ofColour("Golden")
                .withFavouriteToy("bone")
                .bornOn(birthday);
        Assert.assertEquals("bone", jewel.getFavouriteToy());

        Dog lance = Dog.called("Lance")
                .ofBreed("Labrador")
                .ofColour("Black")
                .bornOn(birthday);
        Assert.assertNull(lance.getFavouriteToy());
    }
}
