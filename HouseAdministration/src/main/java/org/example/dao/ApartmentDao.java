package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Apartment;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApartmentDao {
    public static void createApartment(Apartment apartment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(apartment);
            transaction.commit();
        }
    }

    public static Apartment getApartmentById(long apartmentId) {
        Apartment apartment;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            apartment = session.get(Apartment.class, apartmentId);
            transaction.commit();
        }

        return apartment;
    }

    public static void updateApartment(Apartment apartment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(apartment);
            transaction.commit();
        }
    }

    public static void deleteApartment(Apartment apartment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(apartment);
            transaction.commit();
        }
    }

    public static Apartment getApartmentWithResidents(long apartmentId) {
        Apartment apartment;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            apartment = session.createQuery(
                            "select a from Apartment a" +
                                    " left join fetch a.residents" +
                                    " where a.id = :apartmentId",
                            Apartment.class)
                    .setParameter("apartmentId", apartmentId)
                    .getSingleResult();

            transaction.commit();
        }

        return apartment;
    }

    public static Apartment getApartmentWithOwners(long apartmentId) {
        Apartment apartment;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            apartment = session.createQuery(
                    "select a from Apartment a" +
                            " left join fetch a.owners" +
                            " where a.id = :apartmentId",
                    Apartment.class)
                    .setParameter("apartmentId", apartmentId)
                    .getSingleResult();

            transaction.commit();
        }

        return apartment;
    }
}
