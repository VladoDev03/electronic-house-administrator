package org.example;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.Apartment.ApartmentDto;
import org.example.dto.Apartment.CreateApartmentDto;
import org.example.dto.Building.BuildingDto;
import org.example.dto.Building.CreateBuildingDto;
import org.example.dto.Company.CompanyDto;
import org.example.dto.Company.CreateCompanyDto;
import org.example.dto.Employee.CreateEmployeeDto;
import org.example.dto.Employee.EmployeeDto;
import org.example.service.contracts.ApartmentService;
import org.example.service.contracts.BuildingService;
import org.example.service.contracts.CompanyService;
import org.example.service.contracts.EmployeeService;
import org.example.service.implementations.ApartmentServiceImpl;
import org.example.service.implementations.BuildingServiceImpl;
import org.example.service.implementations.CompanyServiceImpl;
import org.example.service.implementations.EmployeeServiceImpl;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtil.getSessionFactory().openSession();

        BuildingService buildingService = new BuildingServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        CompanyService companyService = new CompanyServiceImpl();
        ApartmentService apartmentService = new ApartmentServiceImpl();

        EmployeeDto employeeDto = employeeService.createEmployee(new CreateEmployeeDto("asd", "asd", 1, new HashSet<>(), null));
        CompanyDto companyDto = companyService.createCompany(new CreateCompanyDto("asd", new HashSet<>()));
        BuildingDto buildingDto = buildingService.createBuilding(new CreateBuildingDto("asd", 1, 1, new HashSet<>(), null));
        ApartmentDto apartmentDto = apartmentService.createApartment(new CreateApartmentDto(1, 1, 1, true, null, new HashSet<>(), new HashSet<>()));

        buildingService.assignBuildingToEmployee(employeeDto.getId(), buildingDto.getId());
        employeeService.hireEmployee(employeeDto.getId(), companyDto.getId());
        apartmentService.addApartmentToBuilding(apartmentDto.getId(), buildingDto.getId());
    }
}
