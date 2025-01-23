package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PetDao {
    public static void createPet(Pet pet) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(pet);
            transaction.commit();
        }
    }

    public static Pet getPetById(long petId) {
        Pet pet;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            pet = session.get(Pet.class, petId);
            transaction.commit();
        }

        return pet;
    }

    public static void updatePet(Pet pet) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(pet);
            transaction.commit();
        }
    }

    public static void deletePet(Pet pet) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(pet);
            transaction.commit();
        }
    }
}
