package org.example.service.implementations;

import org.example.dao.CompanyDao;
import org.example.dto.CreateCompanyDto;
import org.example.entity.Company;
import org.example.service.contracts.CompanyService;

public class CompanyServiceImpl implements CompanyService {
    public CreateCompanyDto createCompany(CreateCompanyDto companyDto) {
        Company company = new Company(companyDto.getName(), companyDto.getFoundationDate(), companyDto.getEmployees());
        CompanyDao.createCompany(company);

        return companyDto;
    }
}
