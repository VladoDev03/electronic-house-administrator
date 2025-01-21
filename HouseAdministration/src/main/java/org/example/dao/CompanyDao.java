package org.example.dao;

//import jakarta.validation.Valid;
import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Company;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class CompanyDao {
    public static Company getCompanyById(long id) {
        Company company;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.get(Company.class, id);
            transaction.commit();
        }

        return company;
    }

//    public static void createCompany(@Valid Company company) {
    public static void createCompany(Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }

    public static void deleteCompany(Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(company);
            transaction.commit();
        }
    }

    public static void updateCompany(Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }

    public static Set<Employee> getCompanyEmployees(long id) {
        Company company;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            company = session.createQuery(
                            "select c from Company c" +
                                    " join fetch c.employees" +
                                    " where c.id = :id",
                            Company.class)
                    .setParameter("id", id)
                    .getSingleResult();

            transaction.commit();
        }

        return company.getEmployees();
    }

    public static Company getCompanyWithEmployeesWithBuildings(long companyId) {
        Company company;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            company = session.createQuery(
                            "select distinct c from Company c" +
                                    " left join fetch c.employees as e" +
                                    " left join fetch e.assignedBuildings" +
                                    " where c.id = :companyId",
                            Company.class)
                    .setParameter("companyId", companyId)
                    .getSingleResult();

            transaction.commit();
        }

        return company;
    }

    public static List<Company> getCompaniesWithPayments() {
        List<Company> companies;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            companies = session.createQuery(
                            "select distinct c from Company as c" +
                                    " left join fetch c.employees as e" +
                                    " left join fetch e.assignedBuildings as b" +
                                    " left join fetch b.apartments as a" +
                                    " left join fetch a.payments",
                            Company.class)
                    .getResultList();

            transaction.commit();
        }

        return companies;
    }
}
