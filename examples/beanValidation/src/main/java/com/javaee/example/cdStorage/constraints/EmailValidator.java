package com.javaee.example.cdStorage.constraints;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javaee.example.cdStorage.annotations.Email;


public class EmailValidator implements ConstraintValidator<Email, String> {

    @Override
    public void initialize(Email constraintAnnotation) {
        // nothing to do
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        try {
            new InternetAddress(value);
        } catch (AddressException e) {
            return false;
        }
        return true;
    }

}
