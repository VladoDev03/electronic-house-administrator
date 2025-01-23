package org.example.service.implementations;

import org.example.dao.CompanyDao;
import org.example.dto.Building.BuildingInfoDto;
import org.example.dto.Company.*;
import org.example.dto.Employee.EmployeeBuildingCountDto;
import org.example.dto.Employee.FullEmployeeWithBuildingsInfoDto;
import org.example.entity.Company;
import org.example.entity.Employee;
import org.example.entity.Payment;
import org.example.exception.EntityNotFoundException;
import org.example.service.contracts.CompanyService;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class CompanyServiceImpl implements CompanyService {
    public CompanyDto createCompany(CreateCompanyDto companyDto) {
        Company company = new Company(companyDto.getName(), companyDto.getFoundationDate(), companyDto.getEmployees());
        CompanyDao.createCompany(company);

        CompanyDto result = new CompanyDto(company.getId(), companyDto.getName(), companyDto.getFoundationDate(), companyDto.getEmployees());

        return result;
    }

    @Override
    public void deleteCompany(long companyId) throws EntityNotFoundException {
        Company company = CompanyDao.getCompanyById(companyId);
        CompanyDao.deleteCompany(company);
    }

    @Override
    public CompanyDto getCompanyById(long companyId) throws EntityNotFoundException {
        Company company = CompanyDao.getCompanyById(companyId);
        return new CompanyDto(company.getId(), company.getName(), company.getFoundationDate(), company.getEmployees());
    }

    @Override
    public void updateCompany(UpdateCompanyDto companyToUpdate) {
        Company company = new Company(companyToUpdate.getId(), companyToUpdate.getName(), companyToUpdate.getFoundationDate(), companyToUpdate.getEmployees());
        CompanyDao.updateCompany(company);
    }

    @Override
    public Set<Employee> getCompanyEmployees(long id) throws EntityNotFoundException {
        Set<Employee> employees = CompanyDao.getCompanyEmployees(id);

        return employees;
    }

    @Override
    public FullCompanyInfoDto getCompanyEmployeesWithBuildingsInfo(long companyId) throws EntityNotFoundException {
        Company company = CompanyDao.getCompanyWithEmployeesWithBuildings(companyId);

        FullCompanyInfoDto result = new FullCompanyInfoDto(
                company.getName(),
                company.getFoundationDate(),
                company.getEmployees()
                        .stream()
                        .map(e -> new FullEmployeeWithBuildingsInfoDto(
                                e.getFirstName(),
                                e.getLastName(),
                                e.getAssignedBuildings()
                                        .stream()
                                        .map(building -> new BuildingInfoDto(
                                                building.getAddress(),
                                                building.getFloors(),
                                                building.getArea()
                                        ))
                                        .toList()
                        ))
                        .sorted(
                                Comparator.comparing(FullEmployeeWithBuildingsInfoDto::getFirstName)
                                        .thenComparing(FullEmployeeWithBuildingsInfoDto::getLastName)
                        )

                        .toList()
        );

        return result;
    }

    @Override
    public CompanyWithEmployees getCompanyEmployeesWithBuildingCount(long companyId) throws EntityNotFoundException {
        Company company = CompanyDao.getCompanyWithEmployeesWithBuildings(companyId);

        CompanyWithEmployees result = new CompanyWithEmployees(
                company.getName(),
                company.getEmployees()
                        .stream()
                        .map(e -> new EmployeeBuildingCountDto(
                                e.getFirstName(),
                                e.getLastName(),
                                e.getAssignedBuildings().size()
                        ))
                        .sorted(Comparator.comparing(EmployeeBuildingCountDto::getFirstName)
                                .thenComparing(EmployeeBuildingCountDto::getLastName)
                                .thenComparing(Comparator.comparingInt(EmployeeBuildingCountDto::getBuildingCount).reversed()))

                        .toList()
        );

        return result;
    }

    @Override
    public List<CompanyWithIncomeDto> getCompaniesWithIncome() {
        List<Company> companies = CompanyDao.getCompaniesWithPayments();

        List<CompanyWithIncomeDto> result = companies
                .stream()
                .map(company -> new CompanyWithIncomeDto(
                        company.getName(),
                        company.getFoundationDate(),
                        company.getEmployees()
                                .stream()
                                .flatMap(employee -> employee.getAssignedBuildings().stream())
                                .flatMap(building -> building.getApartments().stream())
                                .flatMap(apartment -> apartment.getPayments().stream())
                                .mapToDouble(Payment::getAmount)
                                .sum()
                ))
                .sorted(Comparator.comparing(CompanyWithIncomeDto::getIncome).reversed())
                .toList();

        return result;
    }
}
