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
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NotNull
@Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$")
@ReportAsSingleViolation
@Constraint(validatedBy = {})
@Retention(RUNTIME)
@Target({ TYPE, METHOD, CONSTRUCTOR, PARAMETER, FIELD })
public @interface ZipCode {

    String message() default "Zip code is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
