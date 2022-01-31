package serenitylabs.tutorials.vetclinic.screenplay.questions;

import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class TheGuests {

    public static TheGuestsOnTheWaitingList onTheWaitingListAt(PetHotel petHotel) {
        return TheGuestsOnTheWaitingList.forThe(petHotel);
    }

    public static TheRegisteredGuests registeredInTheHotel(PetHotel petHotel) {
        return TheRegisteredGuests.in(petHotel);
    }
}
