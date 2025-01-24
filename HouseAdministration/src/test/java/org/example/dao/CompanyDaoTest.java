package org.example.dao;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.entity.Company;
import org.example.exception.EntityNotFoundException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyDaoTest {
    @Test
    public void whenInvalidCompanyName_thenAssertConstraintViolations() {
        Company company = new Company("Company", LocalDate.of(1990, 1, 1), new HashSet<>());

        List<String> messages = validate(company);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("Company and Firm are not valid names!"));
    }

    @Test
    public void whenCompanyNameIsEmpty_thenAssertConstraintViolations() {
        Company company = new Company("", LocalDate.of(1990, 1, 1), new HashSet<>());

        List<String> messages = validate(company);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("Company name cannot be blank!"));
    }

    @Test
    public void whenCompanyNameIsWhiteSpace_thenAssertConstraintViolations() {
        Company company = new Company("   ", LocalDate.of(1990, 1, 1), new HashSet<>());

        List<String> messages = validate(company);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("Company name cannot be blank!"));
    }

    @Test
    public void whenCompanyNameIsTooLong_thenAssertConstraintViolations() {
        Company company = new Company("Too Long Name to be even allowed to exist", LocalDate.of(1990, 1, 1), new HashSet<>());

        List<String> messages = validate(company);

        assertEquals(1, messages.size());
        assertTrue(messages.contains("Company name has to be with up to 20 characters!"));
    }

    @Test
    public void givenCompany_whenSave_thenOk() throws EntityNotFoundException {
        Company company = new Company("Microsoft", LocalDate.of(1990, 1, 1), new HashSet<>());

        CompanyDao.createCompany(company);

        Company companySaved = CompanyDao.getCompanyById(1);
        assertEquals(1, companySaved.getId());
    }

    @Test
    public void givenCompanyId_whenSearch_thenThrowsException() {
        assertThrows(EntityNotFoundException.class, () -> {
            CompanyDao.getCompanyById(1);
        });
    }

    private List<String> validate(Company company) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        return validator.validate(company)
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }
}
