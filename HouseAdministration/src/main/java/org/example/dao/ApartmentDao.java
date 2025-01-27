package org.example.dao;

import jakarta.persistence.NoResultException;
import jakarta.validation.Valid;
import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Apartment;
import org.example.exception.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApartmentDao {
    public static void createApartment(@Valid Apartment apartment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(apartment);
            transaction.commit();
        }
    }

    public static Apartment getApartmentById(long apartmentId) throws EntityNotFoundException {
        Apartment apartment;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            apartment = session.get(Apartment.class, apartmentId);
            transaction.commit();
        }

        if (apartment == null) {
            throw new EntityNotFoundException(apartmentId);
        }

        return apartment;
    }

    public static void updateApartment(@Valid Apartment apartment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(apartment);
            transaction.commit();
        }
    }

    public static void deleteApartment(@Valid Apartment apartment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(apartment);
            transaction.commit();
        }
    }

    public static Apartment getApartmentWithOwners(long apartmentId) throws EntityNotFoundException {
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

        if (apartment == null) {
            throw new EntityNotFoundException(apartmentId);
        }

        return apartment;
    }

    public static Apartment getApartmentWithResidents(long apartmentId) throws EntityNotFoundException {
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
        } catch (NoResultException e) {
            throw new EntityNotFoundException(apartmentId);
        }

        return apartment;
    }
}
