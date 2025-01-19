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
import org.example.dto.Payment.CreatePaymentDto;
import org.example.dto.Payment.PaymentDto;
import org.example.dto.Service.CreateServiceDto;
import org.example.dto.Service.ServiceDto;
import org.example.service.contracts.*;
import org.example.service.implementations.*;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtil.getSessionFactory().openSession();

        BuildingService buildingService = new BuildingServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        CompanyService companyService = new CompanyServiceImpl();
        ApartmentService apartmentService = new ApartmentServiceImpl();
        ServiceService serviceService = new ServiceServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl();

        EmployeeDto employeeDto = employeeService.createEmployee(new CreateEmployeeDto("John", "Doe", 22, new HashSet<>(), null));
        CompanyDto companyDto = companyService.createCompany(new CreateCompanyDto("House Administrator", new HashSet<>()));
        BuildingDto buildingDto = buildingService.createBuilding(new CreateBuildingDto("Sunset Tower", 10, 100, new HashSet<>(), null, null));
        ApartmentDto apartmentDto = apartmentService.createApartment(new CreateApartmentDto(7, 18, 10, true, null, new HashSet<>(), new HashSet<>(), null));
        ServiceDto serviceDto = serviceService.createService(new CreateServiceDto(100, 15, 35, 42, null));
        PaymentDto paymentDto = paymentService.createPayment(new CreatePaymentDto(1500, null));

        buildingService.assignBuildingToEmployee(employeeDto.getId(), buildingDto.getId());
        employeeService.hireEmployee(employeeDto.getId(), companyDto.getId());
        apartmentService.addApartmentToBuilding(apartmentDto.getId(), buildingDto.getId());
//        buildingService.addApartmentToBuilding(apartmentDto.getId(), buildingDto.getId());
        serviceService.setServiceToBuilding(serviceDto.getId(), buildingDto.getId());
        paymentService.addPaymentToApartment(paymentDto.getId(), apartmentDto.getId());
    }
}
