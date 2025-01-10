package org.example.service.implementations;

import org.example.dao.CompanyDao;
import org.example.dto.Company.CompanyDto;
import org.example.dto.Company.CreateCompanyDto;
import org.example.dto.Company.UpdateCompanyDto;
import org.example.entity.Company;
import org.example.entity.Employee;
import org.example.service.contracts.CompanyService;

import java.util.Set;

public class CompanyServiceImpl implements CompanyService {
    public CompanyDto createCompany(CreateCompanyDto companyDto) {
        Company company = new Company(companyDto.getName(), companyDto.getFoundationDate(), companyDto.getEmployees());
        CompanyDao.createCompany(company);

        CompanyDto result = new CompanyDto(company.getId(), companyDto.getName(), companyDto.getFoundationDate(), companyDto.getEmployees());

        return result;
    }

    @Override
    public void deleteCompany(long companyId) {
        Company company = CompanyDao.getCompanyById(companyId);
        CompanyDao.deleteCompany(company);
    }

    @Override
    public CompanyDto getCompanyById(long companyId) {
        Company company = CompanyDao.getCompanyById(companyId);
        return new CompanyDto(company.getId(), company.getName(), company.getFoundationDate(), company.getEmployees());
    }

    @Override
    public void updateCompany(UpdateCompanyDto companyToUpdate) {
        Company company = new Company(companyToUpdate.getId(), companyToUpdate.getName(), companyToUpdate.getFoundationDate(), companyToUpdate.getEmployees());
        CompanyDao.updateCompany(company);
    }

    @Override
    public Set<Employee> getCompanyEmployees(long id) {
        Set<Employee> employees = CompanyDao.getCompanyEmployees(id);

        return employees;
    }
}
