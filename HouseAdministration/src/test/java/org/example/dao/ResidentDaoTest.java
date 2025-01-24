package org.example.dao;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.entity.Resident;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResidentDaoTest {
    @Test
    public void whenResidentInvalidFirstName_thenAssertConstraintViolations() {
        Resident resident = new Resident("", "Asd", 1, true, new HashSet<>(), new HashSet<>());

        List<String> messages = validate(resident);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("First name cannot be blank!"));
    }

    @Test
    public void whenResidentInvalidLastName_thenAssertConstraintViolations() {
        Resident resident = new Resident("Asd", "", 1, true, new HashSet<>(), new HashSet<>());

        List<String> messages = validate(resident);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("Last name cannot be blank!"));
    }

    @Test
    public void whenResidentAgeNotPositive_thenAssertConstraintViolations() {
        Resident resident = new Resident("Asd", "Asd", 0, true, new HashSet<>(), new HashSet<>());

        List<String> messages = validate(resident);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("must be greater than 0"));
    }

    private List<String> validate(Resident resident) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        return validator.validate(resident)
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }
}
