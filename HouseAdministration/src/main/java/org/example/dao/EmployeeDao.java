package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Building;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDao {
    public static Employee getEmployeeById(long id) {
        Employee employee;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        }

        return employee;
    }

    public static void createEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    public static void updateEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }

    public static void deleteEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }

    public static void assignBuilding(Employee employee, Building building) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee.getAssignedBuildings().add(building);
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }

    public static Employee getEmployeeWithBuildings(long employeeId) {
        Employee employee;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            employee = session.createQuery(
                            "select e from Employee e" +
                                    " left join fetch e.assignedBuildings" +
                                    " where e.id = :id",
                            Employee.class)
                    .setParameter("id", employeeId)
                    .getSingleResult();

            transaction.commit();
        }

        return employee;
    }

    public static List<Employee> getAllEmployeesWithBuildings() {
        List<Employee> employees;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            employees = session.createQuery(
                            "select e from Employee e" +
                                    " left join fetch e.assignedBuildings",
                            Employee.class)
                    .getResultList();

            transaction.commit();
        }

        return employees;
    }
}
