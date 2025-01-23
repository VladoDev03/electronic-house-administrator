package org.example.dao;

import jakarta.validation.Valid;
import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Service;
import org.example.exception.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServiceDao {
    public static void createService(@Valid Service service) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(service);
            transaction.commit();
        }
    }

    public static Service getServiceById(long id) throws EntityNotFoundException {
        Service service;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            service = session.get(Service.class, id);
            transaction.commit();
        }

        if (service == null) {
            throw new EntityNotFoundException(id);
        }

        return service;
    }

    public static void updateService(@Valid Service service) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(service);
            transaction.commit();
        }
    }

    public static void deleteService(@Valid Service service) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(service);
            transaction.commit();
        }
    }
}
