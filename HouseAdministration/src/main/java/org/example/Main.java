package org.example;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.Building.BuildingDto;
import org.example.dto.Building.CreateBuildingDto;
import org.example.dto.Employee.CreateEmployeeDto;
import org.example.dto.Employee.EmployeeDto;
import org.example.service.contracts.BuildingService;
import org.example.service.contracts.EmployeeService;
import org.example.service.implementations.BuildingServiceImpl;
import org.example.service.implementations.EmployeeServiceImpl;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtil.getSessionFactory().openSession();

        EmployeeService employeeService = new EmployeeServiceImpl();
        BuildingService buildingService = new BuildingServiceImpl();

        EmployeeDto employeeDto = employeeService.createEmployee(new CreateEmployeeDto("asd", "asd", 1, new HashSet<>(), null));
        BuildingDto buildingDto = buildingService.createBuilding(new CreateBuildingDto("asd", 1, 1, new HashSet<>(), null));

        buildingService.assignBuildingToEmployee(employeeDto.getId(), buildingDto.getId());
    }
}
