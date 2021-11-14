package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class WhenWeCreateANewDog {

    @Test
    public void a_new_dog_should_have_a_name_and_a_breed_and_a_colour() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        assertEquals("Fido", fido.getName());
        assertEquals("Labrador", fido.getBreed());
//        assertEquals("Black", fido.getColours());
    }

    @Test
    public void a_dog_should_be_printed_in_a_readable_form() {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
        assertThat(fido.toString(), is(equalTo("Fido the black labrador")));

        assertThat(fido.toString(), startsWith("Fido"));
        assertThat(fido.toString(), endsWith("labrador"));
        assertThat(fido.toString(), containsString("black"));

        assertThat(fido.toString(), is(equalToIgnoringCase("Fido the BLACK labrador")));

//        assertThat(fido.toString(), endsWithIgnoringCase("LABRADOR"));
    }

    @Test
    public void a_dog_can_have_several_colours() {
        Dog fido = Dog.called("Fido").ofBreed("Labrador")
                .andOfColour("Black", "White");

        assertThat(fido.toString(), is(equalTo("Fido the black and white labrador")));
//        assertThat(fido.getColours(), contains("Black", "White"));
        assertThat(fido.getColours(), hasItem("Black"));
        assertThat(fido.getColours(), not(hasItem("Golden")));


    }
}
