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
import org.example.dto.Pet.CreatePetDto;
import org.example.dto.Pet.PetDto;
import org.example.dto.Resident.CreateResidentDto;
import org.example.dto.Resident.ResidentDto;
import org.example.dto.Service.CreateServiceDto;
import org.example.dto.Service.ServiceDto;
import org.example.service.contracts.*;
import org.example.service.implementations.*;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtil.getSessionFactory().openSession();

        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        BuildingService buildingService = new BuildingServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl(buildingService);
        CompanyService companyService = new CompanyServiceImpl();
        ApartmentService apartmentService = new ApartmentServiceImpl();
        ServiceService serviceService = new ServiceServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl(buildingService);
        ResidentService residentService = new ResidentServiceImpl();
        PetService petService = new PetServiceImpl();

        EmployeeDto employeeDto1 = employeeService.createEmployee(new CreateEmployeeDto("John", "Doe", 22, new HashSet<>(), null));
        CompanyDto companyDto1 = companyService.createCompany(new CreateCompanyDto("House Administrator", new HashSet<>()));
        BuildingDto buildingDto1 = buildingService.createBuilding(new CreateBuildingDto("Sunset Tower", 10, 100, new HashSet<>(), null, null));
        ApartmentDto apartmentDto1 = apartmentService.createApartment(new CreateApartmentDto(7, 18, 10, true, null, new HashSet<>(), new HashSet<>(), null));
        ServiceDto serviceDto1 = serviceService.createService(new CreateServiceDto(100, 15, 35, 42, null));
        PaymentDto paymentDto1 = paymentService.createPayment(new CreatePaymentDto(1500, null));
        PaymentDto paymentDto3 = paymentService.createPayment(new CreatePaymentDto(1700, null));
        PetDto petDto1 = petService.createPet(new CreatePetDto(true, null));
        PetDto petDto2 = petService.createPet(new CreatePetDto(false, null));
        ResidentDto residentDto1 = residentService.createResident(new CreateResidentDto("John", "Doe", 54, false, new HashSet<>(), null));
        ResidentDto residentDto2 = residentService.createResident(new CreateResidentDto("Alice", "Johnson", 48, true, new HashSet<>(), null));
        ResidentDto residentDto3 = residentService.createResident(new CreateResidentDto("Jane", "Smith", 21, true, new HashSet<>(), null));

        buildingService.assignBuildingToEmployee(employeeDto1.getId(), buildingDto1.getId());
        employeeService.hireEmployee(employeeDto1.getId(), companyDto1.getId());
        apartmentService.addApartmentToBuilding(apartmentDto1.getId(), buildingDto1.getId());
        serviceService.setServiceToBuilding(serviceDto1.getId(), buildingDto1.getId());
        paymentService.addPaymentToApartment(apartmentDto1.getId(), paymentDto1.getId());
        paymentService.addPaymentToApartment(apartmentDto1.getId(), paymentDto3.getId());

        residentService.addResidentToApartment(residentDto1.getId(), apartmentDto1.getId());
        residentService.addResidentToApartment(residentDto2.getId(), apartmentDto1.getId());
        residentService.addResidentToApartment(residentDto3.getId(), apartmentDto1.getId());

        apartmentService.setApartmentOwner(apartmentDto1.getId(), residentDto1.getId());
        apartmentService.setApartmentOwner(apartmentDto1.getId(), residentDto2.getId());

        EmployeeDto employeeDto2 = employeeService.createEmployee(new CreateEmployeeDto("John", "Doe", 54, new HashSet<>(), null));
        EmployeeDto employeeDto3 = employeeService.createEmployee(new CreateEmployeeDto("Alice", "Johnson", 48, new HashSet<>(), null));
        CompanyDto companyDto2 = companyService.createCompany(new CreateCompanyDto("House Administrator", new HashSet<>()));
        BuildingDto buildingDto2 = buildingService.createBuilding(new CreateBuildingDto("What else", 10, 100, new HashSet<>(), null, null));
        BuildingDto buildingDto3 = buildingService.createBuilding(new CreateBuildingDto("Moon hut", 10, 100, new HashSet<>(), null, null));
        BuildingDto buildingDto4 = buildingService.createBuilding(new CreateBuildingDto("Sunset Tower Twice", 10, 100, new HashSet<>(), null, null));
        ApartmentDto apartmentDto2 = apartmentService.createApartment(new CreateApartmentDto(7, 19, 10, true, null, new HashSet<>(), new HashSet<>(), null));
        ServiceDto serviceDto2 = serviceService.createService(new CreateServiceDto(100, 15, 35, 42, null));
        PaymentDto paymentDto2 = paymentService.createPayment(new CreatePaymentDto(1200, null));
        ResidentDto residentDto4 = residentService.createResident(new CreateResidentDto("John", "Doe", 54, false, new HashSet<>(), null));
        ResidentDto residentDto5 = residentService.createResident(new CreateResidentDto("Alice", "Johnson", 48, true, new HashSet<>(), null));
        ResidentDto residentDto6 = residentService.createResident(new CreateResidentDto("Jane", "Smith", 21, true, new HashSet<>(), null));

        buildingService.assignBuildingToEmployee(employeeDto2.getId(), buildingDto2.getId());
        buildingService.assignBuildingToEmployee(employeeDto2.getId(), buildingDto3.getId());
        buildingService.assignBuildingToEmployee(employeeDto2.getId(), buildingDto4.getId());

        employeeService.hireEmployee(employeeDto2.getId(), companyDto2.getId());
        employeeService.hireEmployee(employeeDto3.getId(), companyDto2.getId());
        apartmentService.addApartmentToBuilding(apartmentDto2.getId(), buildingDto2.getId());
        serviceService.setServiceToBuilding(serviceDto2.getId(), buildingDto2.getId());
        paymentService.addPaymentToApartment(apartmentDto2.getId(), paymentDto2.getId());

        residentService.addResidentToApartment(residentDto4.getId(), apartmentDto2.getId());
        residentService.addResidentToApartment(residentDto5.getId(), apartmentDto2.getId());
        residentService.addResidentToApartment(residentDto6.getId(), apartmentDto2.getId());

        apartmentService.setApartmentOwner(apartmentDto2.getId(), residentDto4.getId());
        apartmentService.setApartmentOwner(apartmentDto2.getId(), residentDto5.getId());

        ApartmentDto apartmentDto3 = apartmentService.createApartment(new CreateApartmentDto(7, 17, 10, true, null, new HashSet<>(), new HashSet<>(), null));
        ResidentDto residentDto7 = residentService.createResident(new CreateResidentDto("Bob", "Brown", 63, true, new HashSet<>(), null));
        ResidentDto residentDto8 = residentService.createResident(new CreateResidentDto("Bob", "Brown", 30, true, new HashSet<>(), null));
        apartmentService.addApartmentToBuilding(apartmentDto3.getId(), buildingDto1.getId());
        residentService.addResidentToApartment(residentDto7.getId(), apartmentDto3.getId());
        residentService.addResidentToApartment(residentDto8.getId(), apartmentDto3.getId());

        paymentService.addMultiplePaymentsToBuilding(buildingDto1.getId());

        sb.append(companyService.getCompanyEmployeesWithBuildingCount(companyDto2.getId()));
        sb.append(companyService.getCompanyEmployeesWithBuildingCount(companyDto2.getId()).getEmployees().size());
        sb.append(buildingService.getBuildingResidents(buildingDto1.getId()));
        sb.append(buildingService.getBuildingWithApartmentsInfoWithResidentsInfo(buildingDto1.getId()));
        companyService.getCompaniesWithIncome().forEach(x -> sb.append(x.toString()));
        sb.append(companyService.getCompanyEmployeesWithBuildingsInfo(companyDto2.getId()));
        buildingService.createPayments(buildingDto1.getId()).forEach(x -> sb.append(x.toString()));
        petService.addPetToApartment(apartmentDto1.getId(), petDto1.getId());
        petService.addPetToApartment(apartmentDto1.getId(), petDto2.getId());
        sb.append(employeeService.getEmployeePayments(employeeDto1.getId()));

        System.out.println(sb.toString());
    }
}
