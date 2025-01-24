package org.example.dao;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.entity.Apartment;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ApartmentDaoTest {
    @Test
    public void whenApartmentNonPositiveValues_thenAssertConstraintViolations() {
        Apartment apartment = new Apartment(0, 0, 0, null, new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>());

        List<String> messages = validate(apartment);

        assertEquals(2, messages.size());
        assertTrue(messages.contains("must be greater than 0"));
    }

    private List<String> validate(Apartment apartment) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        return validator.validate(apartment)
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }
}
