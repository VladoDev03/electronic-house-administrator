package org.example.dao;

import jakarta.validation.Valid;
import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Building;
import org.example.exception.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BuildingDao {
    public static Building getBuildingById(long id) throws EntityNotFoundException {
        Building building;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            building = session.get(Building.class, id);
            transaction.commit();
        }

        if (building == null) {
            throw new EntityNotFoundException(id);
        }

        return building;
    }

    public static void createBuilding(@Valid Building building) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(building);
            transaction.commit();
        }
    }

    public static void deleteBuilding(@Valid Building building) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(building);
            transaction.commit();
        }
    }

    public static void updateBuilding(@Valid Building building) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(building);
            transaction.commit();
        }
    }

    public static Building getBuildingWithApartmentsWithResidentsWithService(long buildingId) throws EntityNotFoundException {
        Building building;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            building = session.createQuery(
                            "select distinct b from Building as b" +
                                    " left join fetch b.apartments as a" +
                                    " left join fetch b.service as s" +
                                    " left join fetch a.residents as r" +
                                    " left join fetch a.owners as o" +
                                    " left join fetch a.pets as p" +
                                    " where b.id = :buildingId",
                            Building.class)
                    .setParameter("buildingId", buildingId)
                    .getSingleResult();

            transaction.commit();
        }

        if (building == null) {
            throw new EntityNotFoundException(buildingId);
        }

        return building;
    }

    public static Building getBuildingWithResidents(long buildingId) throws EntityNotFoundException {
        Building building;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            building = session.createQuery(
                            "select distinct b from Building as b" +
                                    " left join fetch b.apartments as a" +
                                    " left join fetch a.residents" +
                                    " where b.id = :buildingId",
                            Building.class
                    )
                    .setParameter("buildingId", buildingId)
                    .getSingleResult();

            transaction.commit();
        }

        if (building == null) {
            throw new EntityNotFoundException(buildingId);
        }

        return building;
    }

    public static Building getBuildingWithServices(long buildingId) throws EntityNotFoundException {
        Building building;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            building = session.createQuery(
                            "select distinct b from Building as b" +
                                    " left join fetch b.service as s" +
                                    " where b.id = :buildingId",
                            Building.class
                    )
                    .setParameter("buildingId", buildingId)
                    .getSingleResult();

            transaction.commit();
        }

        if (building == null) {
            throw new EntityNotFoundException(buildingId);
        }

        return building;
    }
}
