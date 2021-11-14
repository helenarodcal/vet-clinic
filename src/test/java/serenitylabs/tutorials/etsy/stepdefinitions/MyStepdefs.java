package serenitylabs.tutorials.etsy.stepdefinitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import serenitylabs.tutorials.etsy.domain.ACustomer;
import serenitylabs.tutorials.etsy.domain.Customer;
import serenitylabs.tutorials.etsy.domain.CustomerType;

public class MyStepdefs {
    Customer customer;

//    @ParameterType("normal|priority|golden")
//    public CustomerType customerType(String value) {
//        return CustomerType.valueOf(value);
//    }

    @Given("{word} is a {word} customer who lives in {word}")
    public void customer_is_of_customer_type_and_lives_in_a_country(String name, String customerType, String country) {

//        customer = new Customer();
//        customer.setCountry(country);
//        customer.setCustomerType(customerType);
//        customer.setName(name);
        customer = ACustomer.called(name)
                .ofType(customerType)
                .whoLivesIn(country)
                .build();

        System.out.println(customer);
//        List<String> items =  Splitter
//                .on(",")
//                .trimResults()
//                .omitEmptyStrings()
//                .limit(3)
//                .splitToList("a,, b,c");
//        System.out.println(items);
    }
//
//    @Given("{word} is a {customerType} customer")
//    public void customer_is_of_customer_type(String name, String customerType) {
//
//        customer = ACustomer.called(name)
//                .ofType(customerType)
//                .build();
//    }
//
//    @Given("{word} lives in {country}")
//    public void customer_lives_in_a_country(String name, String country) {
//
//        customer = ACustomer.called(name)
//                .whoLivesIn(country)
//                .build();
//    }
    @Given("Fabien want to purchase the following items:")
    public void fabien_want_to_purchase_the_following_items(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @When("he checks out his shopping cart")
    public void he_checks_out_his_shopping_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the total price should be")
    public void the_total_price_should_be(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

}
