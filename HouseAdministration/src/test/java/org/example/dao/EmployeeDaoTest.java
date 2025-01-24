package org.example.dao;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeDaoTest {
    @Test
    public void whenEmployeeInvalidFirstName_thenAssertConstraintViolations() {
        Employee employee = new Employee("", "Asd", 1, new HashSet<>(), null);

        List<String> messages = validate(employee);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("First name cannot be blank!"));
    }

    @Test
    public void whenEmployeeInvalidLastName_thenAssertConstraintViolations() {
        Employee employee = new Employee("Asd", "", 1, new HashSet<>(), null);

        List<String> messages = validate(employee);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("Last name cannot be blank!"));
    }

    @Test
    public void whenEmployeeAgeNotPositive_thenAssertConstraintViolations() {
        Employee employee = new Employee("Asd", "Asd", 0, new HashSet<>(), null);

        List<String> messages = validate(employee);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("must be greater than 0"));
    }

    private List<String> validate(Employee employee) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        return validator.validate(employee)
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }
}
