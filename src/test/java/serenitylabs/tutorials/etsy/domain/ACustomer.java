package serenitylabs.tutorials.etsy.domain;

public class ACustomer {

    private static final String DEFAULT_COUNTRY = "UK";
    private static final String DEFAULT_CUSTOMER_TYPE = "Standard";

    String name;
    String country = DEFAULT_COUNTRY;
    String customerType = DEFAULT_CUSTOMER_TYPE;

    public ACustomer(String name) {
        this.name = name;
    }

    public static ACustomer called(String name) {
//        public static Customer called(String name) {
//        Customer newCustomer = new Customer();
//        newCustomer.setName(name);
//        newCustomer.setCountry(DEFAULT_COUNTRY);
//        newCustomer.setCustomerType(DEFAULT_CUSTOMER_TYPE);
//        return newCustomer;
        return new ACustomer(name);
    }

    public ACustomer ofType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    public ACustomer whoLivesIn(String country) {
        this.country = country;
        return this;
    }

    public Customer build() {
        return new Customer(name, country, customerType);
    }

}
