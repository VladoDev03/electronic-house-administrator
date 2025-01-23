package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Building;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BuildingDao {
    public static Building getBuildingById(long id) {
        Building building;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            building = session.get(Building.class, id);
            transaction.commit();
        }

        return building;
    }

    public static void createBuilding(Building building) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(building);
            transaction.commit();
        }
    }

    public static void deleteBuilding(Building building) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(building);
            transaction.commit();
        }
    }

    public static void updateBuilding(Building building) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(building);
            transaction.commit();
        }
    }

    public static Building getBuildingWithApartmentsWithResidentsWithSerivce(long buildingId) {
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

        return building;
    }

    public static Building getBuildingWithResidents(long buildingId) {
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

        return building;
    }

    public static Building getBuildingWithServices(long buildingId) {
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

        return building;
    }
}
