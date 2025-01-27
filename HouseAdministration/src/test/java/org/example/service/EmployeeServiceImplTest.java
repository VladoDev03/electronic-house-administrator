package org.example.service;

import org.example.dao.EmployeeDao;
import org.example.entity.*;
import org.example.exception.EntityNotFoundException;
import org.example.service.contracts.BuildingService;
import org.example.service.implementations.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class EmployeeServiceImplTest {
    @Mock
    private BuildingService buildingService;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    EmployeeServiceImplTest() {
        openMocks(this);
    }

    @Test
    void getEmployeePayments_employeeNotFound() {
        assertThrows(EntityNotFoundException.class, () -> employeeService.getEmployeePayments(1000));
    }

    @Test
    void getEmployeePayments_noAssignedBuildings() throws EntityNotFoundException {
        Employee employee = new Employee("Jane", "Doe", 25, Collections.emptySet(), null);
        EmployeeDao.createEmployee(employee);

        double totalPayments = employeeService.getEmployeePayments(employee.getId());

        assertEquals(0.0, totalPayments, 0.01);
    }

    @Test
    void getEmployeePayments_noPaymentsForBuilding() throws EntityNotFoundException {
        Building building1 = new Building("Sunset Tower", 10, 100, new HashSet<>(), null, null);

        Employee employee = new Employee("Bob", "Smith", 40, Set.of(building1), null);
        EmployeeDao.createEmployee(employee);

        when(buildingService.createPayments(building1.getId())).thenReturn(Collections.emptyList());

        double totalPayments = employeeService.getEmployeePayments(employee.getId());

        assertEquals(0.0, totalPayments, 0.01);
    }
}
