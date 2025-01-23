package org.example.service.contracts;

import org.example.dto.Company.*;
import org.example.entity.Employee;
import org.example.exception.EntityNotFoundException;

import java.util.List;
import java.util.Set;

public interface CompanyService {
    CompanyDto createCompany(CreateCompanyDto companyDto);
    void deleteCompany(long companyId) throws EntityNotFoundException;
    CompanyDto getCompanyById(long companyId) throws EntityNotFoundException;
    void updateCompany(UpdateCompanyDto companyToUpdate);
    Set<Employee> getCompanyEmployees(long id) throws EntityNotFoundException;
    FullCompanyInfoDto getCompanyEmployeesWithBuildingsInfo(long companyId) throws EntityNotFoundException;
    CompanyWithEmployees getCompanyEmployeesWithBuildingCount(long companyId) throws EntityNotFoundException;
    List<CompanyWithIncomeDto> getCompaniesWithIncome();
}
