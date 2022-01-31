package serenitylabs.tutorials.vetclinic.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.CheckIn;

import static org.assertj.core.api.Assertions.*;

@RunWith(SerenityRunner.class)
public class WhenCheckingIntoThePetHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel() {

        //GIVEN
        Actor petra = Actor.named("Petra the cat owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel Fluffy Cares");

        //WHEN
        petra.attemptsTo(
                CheckIn.thePet(ginger).into(petHotel)
        );

        //THEN
        assertThat(petHotel.getPets()).contains(ginger);
    }
}
