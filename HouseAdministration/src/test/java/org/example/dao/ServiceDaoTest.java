package org.example.dao;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.entity.Service;
import org.example.exception.EntityNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceDaoTest {
    @Test
    public void whenServiceNonPositiveValues_thenAssertConstraintViolations() {
        Service service = new Service(0, 0, 0, 0, 0, null);

        List<String> messages = validate(service);

        assertEquals(5, messages.size());
        assertTrue(messages.contains("must be greater than 0"));
    }

    @Test
    public void givenService_whenSave_thenOk() throws EntityNotFoundException {
        Service service = new Service(2, 2, 2, 2, 2, null);

        ServiceDao.createService(service);

        Service serviceSaved = ServiceDao.getServiceById(1);
        assertEquals(1, serviceSaved.getId());
    }

    @Test
    public void givenServiceId_whenSearch_thenThrowsException() {
        assertThrows(EntityNotFoundException.class, () -> {
            ServiceDao.getServiceById(2);
        });
    }

    private List<String> validate(Service service) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        return validator.validate(service)
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }
}
