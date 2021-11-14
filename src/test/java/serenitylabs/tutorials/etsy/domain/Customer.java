package serenitylabs.tutorials.etsy.domain;

public class Customer {
    private String name;
    private String country;
    private String customerType;
//once you have a builder (ACustomer), make the class "Read-only"
//    by removing the setter methods from this class
    public Customer(String name, String country, String customerType) {
        this.name = name;
        this.country = country;
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCustomerType() {
        return customerType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }
}
