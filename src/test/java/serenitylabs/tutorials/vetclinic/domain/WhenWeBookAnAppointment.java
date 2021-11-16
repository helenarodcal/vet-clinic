package serenitylabs.tutorials.vetclinic.domain;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static serenitylabs.tutorials.vetclinic.domain.Appointment.isAfter;
import static serenitylabs.tutorials.vetclinic.domain.Appointment.isBefore;

public class WhenWeBookAnAppointment {

    private static final LocalDateTime TODAY_AT_2_PM = LocalDateTime.now().withHour(14).withMinute(0);
    private static final LocalDateTime TOMORROW_AT_5_PM = LocalDateTime.now().plusDays(1).withHour(17).withMinute(0);

    @Test
    public void an_appointment_has_a_patient_name_an_owner_and_a_date() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").at(TODAY_AT_2_PM);

        //junit
        assertEquals("Fido",appointment.getPetName());
        assertEquals("Fred",appointment.getOwner());
        assertEquals(TODAY_AT_2_PM,appointment.getAppointmentTime());

        //hamcrest
        assertThat(appointment.getPetName(), is(equalTo("Fido")));
        assertThat(appointment.getOwner(), is(equalTo("Fred")));
        assertThat(appointment.getAppointmentTime(), is(equalTo(TODAY_AT_2_PM)));

        //assertj
        assertThat(appointment.getPetName()).isEqualTo("Fido");
        assertThat(appointment.getOwner()).isEqualTo("Fred");
        assertThat(appointment.getAppointmentTime()).isEqualTo(TODAY_AT_2_PM);
    }

    @Test
    public void an_appointment_can_have_an_optional_reason() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").because("He is sick").at(TODAY_AT_2_PM);

        //junit
        assertEquals(true,appointment.getReason().isPresent());
        assertEquals("He is sick",appointment.getReason().get());

        //hamcrest
        assertThat(appointment.getReason().isPresent());
        assertThat(appointment.getReason().get(), is(equalTo("He is sick")));
    }

    @Test
    public void compare_appointment_dates() {
        Appointment appointment1 = Appointment.forPetCalled("Fido").ownedBy("Fred").because("He is sick").at(TODAY_AT_2_PM);
        Appointment appointment2 = Appointment.forPetCalled("Fido").ownedBy("Fred").because("He needs to get a vaccine").at(TOMORROW_AT_5_PM);

        assertTrue(isBefore(appointment1.getAppointmentTime(), appointment2.getAppointmentTime()));
        assertFalse(isBefore(appointment2.getAppointmentTime(), appointment1.getAppointmentTime()));
        assertFalse(isAfter(appointment1.getAppointmentTime(), appointment2.getAppointmentTime()));
        assertTrue(isAfter(appointment2.getAppointmentTime(), appointment1.getAppointmentTime()));

        assertThat(appointment1.getAppointmentTime().isBefore(appointment2.getAppointmentTime()));
        assertThat(appointment2.getAppointmentTime().isAfter(appointment1.getAppointmentTime()));
        assertThat(appointment2.getAppointmentTime().isAfter(LocalDateTime.now()));
    }
}
