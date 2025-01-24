package org.example.dao;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.entity.Building;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuildingDaoTest {
    @Test
    public void whenBuildingNonPositiveValues_thenAssertConstraintViolations() {
        Building building = new Building("Somewhere", 0, 0, new HashSet<>(), null, null);

        List<String> messages = validate(building);

        assertEquals(2, messages.size());
        assertTrue(messages.contains("must be greater than 0"));
    }

    @Test
    public void whenBuildingAddressIsEmpty_thenAssertConstraintViolations() {
        Building building = new Building("", 1, 1, new HashSet<>(), null, null);

        List<String> messages = validate(building);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("Building address cannot be blank!"));
    }

    @Test
    public void whenBuildingAddressIsWhiteSpace_thenAssertConstraintViolations() {
        Building building = new Building("    ", 1, 1, new HashSet<>(), null, null);

        List<String> messages = validate(building);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("Building address cannot be blank!"));
    }

    @Test
    public void whenBuildingAddressIsTooLong_thenAssertConstraintViolations() {
        Building building = new Building("Somewhere at Anytime or nowhere and never", 1, 1, new HashSet<>(), null, null);

        List<String> messages = validate(building);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("Building address has to be with up to 20 characters!"));
    }

    private List<String> validate(Building building) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        return validator.validate(building)
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }
}
