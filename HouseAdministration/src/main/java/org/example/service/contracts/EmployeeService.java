package org.example.service.contracts;

import org.example.dto.Employee.CreateEmployeeDto;
import org.example.dto.Employee.EmployeeBuildingCountDto;
import org.example.dto.Employee.EmployeeDto;
import org.example.dto.Employee.UpdateEmployeeDto;

import java.util.List;
import java.util.Set;

public interface EmployeeService {
    EmployeeDto createEmployee(CreateEmployeeDto employeeDto);
    void deleteEmployee(long id);
    EmployeeDto getEmployeeById(long id);
    void updateEmployee(UpdateEmployeeDto employeeDto);
    void hireEmployee(long employeeId, long companyId);
    List<EmployeeBuildingCountDto> getEmployeesWithBuildingCount();
}
