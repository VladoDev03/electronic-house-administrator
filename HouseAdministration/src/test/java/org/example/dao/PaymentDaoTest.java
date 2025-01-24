package org.example.dao;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.entity.Payment;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentDaoTest {
    @Test
    public void whenInvalidCompanyName_thenAssertConstraintViolations() {
        Payment payment = new Payment(0, LocalDate.of(1990, 1, 1), null);

        List<String> messages = validate(payment);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("must be greater than 0"));
    }

    private List<String> validate(Payment payment) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        return validator.validate(payment)
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }
}
