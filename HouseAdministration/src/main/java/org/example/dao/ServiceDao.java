package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Service;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServiceDao {
    public static void createService(Service service) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(service);
            transaction.commit();
        }
    }

    public static Service getServiceById(long id) {
        Service service;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            service = session.get(Service.class, id);
            transaction.commit();
        }

        return service;
    }

    public static void updateService(Service service) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(service);
            transaction.commit();
        }
    }

    public static void deleteService(Service service) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(service);
            transaction.commit();
        }
    }
}
