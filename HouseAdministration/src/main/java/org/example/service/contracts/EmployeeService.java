package org.example.service.contracts;

import org.example.dto.Employee.CreateEmployeeDto;
import org.example.dto.Employee.EmployeeDto;
import org.example.dto.Employee.UpdateEmployeeDto;
import org.example.exception.EntitiesAlreadyRelatedException;
import org.example.exception.EntityNotFoundException;


public interface EmployeeService {
    EmployeeDto createEmployee(CreateEmployeeDto employeeDto);
    void deleteEmployee(long id) throws EntityNotFoundException;
    EmployeeDto getEmployeeById(long id) throws EntityNotFoundException;
    void updateEmployee(UpdateEmployeeDto employeeDto);
    void hireEmployee(long employeeId, long companyId) throws EntityNotFoundException, EntitiesAlreadyRelatedException;
    double getEmployeePayments(long employeeId) throws EntityNotFoundException;
}
