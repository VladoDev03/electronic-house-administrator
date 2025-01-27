package org.example.dao;

import jakarta.persistence.NoResultException;
import jakarta.validation.Valid;
import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Employee;
import org.example.exception.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDao {
    public static Employee getEmployeeById(long id) throws EntityNotFoundException {
        Employee employee;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        }

        if (employee == null) {
            throw new EntityNotFoundException(id);
        }

        return employee;
    }

    public static void createEmployee(@Valid Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        }
    }

    public static void updateEmployee(@Valid Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(employee);
            transaction.commit();
        }
    }

    public static void deleteEmployee(@Valid Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(employee);
            transaction.commit();
        }
    }

    public static Employee getEmployeeWithBuildings(long employeeId) throws EntityNotFoundException {
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
        } catch (NoResultException e) {
            throw new EntityNotFoundException(employeeId);
        }

        return employee;
    }
}
