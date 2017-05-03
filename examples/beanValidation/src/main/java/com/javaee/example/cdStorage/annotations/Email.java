package com.javaee.example.cdStorage.annotations;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.javaee.example.cdStorage.constraints.EmailValidator;

@Constraint(validatedBy = { EmailValidator.class })
@Retention(RUNTIME)
@Target({ TYPE, METHOD, CONSTRUCTOR, PARAMETER, FIELD })
public @interface Email {
    String message() default "Email is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
