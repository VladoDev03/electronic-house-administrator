package org.example.service.implementations;

import org.example.dao.CompanyDao;
import org.example.dao.EmployeeDao;
import org.example.dto.Employee.CreateEmployeeDto;
import org.example.dto.Employee.EmployeeDto;
import org.example.dto.Employee.UpdateEmployeeDto;
import org.example.entity.Company;
import org.example.entity.Employee;
import org.example.service.contracts.EmployeeService;

import java.util.HashSet;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public EmployeeDto createEmployee(CreateEmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getAge(),
                employeeDto.getAssignedBuildings(),
                employeeDto.getCompany()
        );

        EmployeeDao.createEmployee(employee);

        EmployeeDto result = new EmployeeDto(
                employee.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getAge(),
                employeeDto.getAssignedBuildings(),
                employeeDto.getCompany()
        );

        return result;
    }

    @Override
    public void deleteEmployee(long id) {
        Employee employee = EmployeeDao.getEmployeeById(id);
        EmployeeDao.deleteEmployee(employee);
    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        Employee employee = EmployeeDao.getEmployeeById(id);

        EmployeeDto result = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getAge(),
                employee.getAssignedBuildings(),
                employee.getCompany()
        );

        return result;
    }

    @Override
    public void updateEmployee(UpdateEmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getAge(),
                employeeDto.getAssignedBuildings(),
                employeeDto.getCompany()
        );

        EmployeeDao.updateEmployee(employee);
    }

    @Override
    public void hireEmployee(long employeeId, long companyId) {
        Employee employee = EmployeeDao.getEmployeeById(employeeId);
        Company company = CompanyDao.getCompanyById(companyId);

        UpdateEmployeeDto updatedEmployee = new UpdateEmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getAge(),
                employee.getAssignedBuildings(),
                company
        );

        updateEmployee(updatedEmployee);
    }
}
