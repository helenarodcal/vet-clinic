package serenitylabs.tutorials.vetclinic.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import org.junit.Assert;

//import static org.hamcrest.CoreMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class WhenCalculatingTotalPrices {

    @Test
    public void total_consultation_price_should_include_20_percent_tax() throws Exception {
        // GIVEN
        int netPrice = 100;

        // WHEN
        int totalPrice = TotalConsultationPrice.includingTax().forANetPriceOf(netPrice);

        // THEN
//        assertEquals(120, totalPrice);
        //hamcrest
        Assert.assertThat(totalPrice, equalTo(120));
        Assert.assertThat(totalPrice, greaterThan(netPrice));
        //assertj
        assertThat(totalPrice).isEqualTo(120);
        assertThat(totalPrice).isGreaterThan(netPrice);


    }
}
