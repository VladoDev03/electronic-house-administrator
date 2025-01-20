package org.example.service.contracts;

import org.example.dto.Company.*;
import org.example.entity.Employee;

import java.util.List;
import java.util.Set;

public interface CompanyService {
    CompanyDto createCompany(CreateCompanyDto companyDto);
    void deleteCompany(long companyId);
    CompanyDto getCompanyById(long companyId);
    void updateCompany(UpdateCompanyDto companyToUpdate);
    Set<Employee> getCompanyEmployees(long id);
    FullCompanyInfoDto getCompanyEmployeesWithBuildingsInfo(long companyId);
    CompanyWithEmployees getCompanyEmployeesWithBuildingCount(long companyId);
    List<CompanyWithIncomeDto> getCompaniesWithIncome();
}
