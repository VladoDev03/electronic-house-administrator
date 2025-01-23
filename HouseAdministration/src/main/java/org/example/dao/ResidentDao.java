package org.example.dao;

import jakarta.validation.Valid;
import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Apartment;
import org.example.entity.Resident;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

public class ResidentDao {
    public static Resident getResidentById(long residentId) {
        Resident resident;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            resident = session.get(Resident.class, residentId);
            transaction.commit();
        }

        return resident;
    }

    public static void createResident(@Valid Resident resident) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(resident);
            transaction.commit();
        }
    }

    public static void updateResident(@Valid Resident resident) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(resident);
            transaction.commit();
        }
    }

    public static void deleteResident(@Valid Resident resident) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(resident);
            transaction.commit();
        }
    }

    public static Set<Apartment> getResidentOwnedApartments(long id) {
        Resident resident;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            resident = session.createQuery(
                            "select r from Resident r" +
                                    " join fetch r.ownedApartments" +
                                    " where r.id = :id",
                            Resident.class)
                    .setParameter("id", id)
                    .getSingleResult();

            transaction.commit();
        }

        return resident.getOwnedApartments();
    }
}
