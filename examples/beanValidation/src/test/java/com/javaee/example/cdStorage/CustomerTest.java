package com.javaee.example.cdStorage;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class CustomerTest {

    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private static Validator validator = validatorFactory.getValidator();

    @Test
    public void testValidateCustomer() {
        Date date = new Date(System.currentTimeMillis() - 100);
        Address address = new Address("Str", null, "Moscow", null, "325-552", "Russia");
        Customer customer = new Customer("Alex", "Hall", "1@test.com", "255442255", date, address);
        assertTrue(validator.validate(customer).size() == 0);
        customer = new Customer("Alex", "Hall", null, "255442255", date, address);
        assertTrue(validator.validate(customer).size() == 1);
    }
}
