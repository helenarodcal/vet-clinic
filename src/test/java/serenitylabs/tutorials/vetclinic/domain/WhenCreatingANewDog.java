package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenCreatingANewDog {

    @Test
    public void a_new_dog_should_have_a_name() {
        LocalDateTime birthday = LocalDateTime.now();

        Dog bobby = Dog.called("Bobby")
                .ofBreed("Labrador") //mandatory field
                .ofColour("black") //also mandatory
                .withFavouriteFood("pizza") //optional fields
                .bornOn(birthday);

        Assert.assertEquals("Bobby", bobby.getName());
        Assert.assertEquals("Labrador", bobby.getBreed());
        Assert.assertEquals("black", bobby.getColour());
        Assert.assertEquals(birthday, bobby.getBirthdate());
        Assert.assertEquals("pizza", bobby.getFavouriteFood());

    }
}
