package com.javaee.example.cdStorage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import org.junit.Test;

import com.javaee.example.cdStorage.validationGroups.PrintingCatalog;

public class CDItemTest {

    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private static Validator validator = validatorFactory.getValidator();

    @Test
    public void testValidatCDItemFields() throws Exception {
        CDItem item = new CDItem("title", new BigDecimal("-10.01"), null, 2, 123f);
        assertEquals(1, validator.validate(item).size());

        item = new CDItem("title", BigDecimal.TEN, null, 2, 123f);
        assertTrue(validator.validate(item).size() == 0);
        Set<ConstraintViolation<CDItem>> violations = validator.validate(item, PrintingCatalog.class);
        assertEquals(1, violations.size());
        assertEquals("Description shouldn't be null", violations.iterator().next().getMessage());


        ExecutableValidator executableValidator = validator.forExecutables();
        Constructor<CDItem> constructor = CDItem.class.getConstructor(String.class, BigDecimal.class, String.class,
                                                                      int.class, Float.class);
        violations = executableValidator.validateConstructorParameters(constructor,
                                                            new Object[] { "title", BigDecimal.TEN, null, 0, 123f });
        assertEquals(1, violations.size());

        Method method = CDItem.class.getMethod("calculatePrice", BigDecimal.class);
        violations = executableValidator.validateReturnValue(item, method, BigDecimal.TEN);
        assertTrue(violations.size() == 0);
    }
}
