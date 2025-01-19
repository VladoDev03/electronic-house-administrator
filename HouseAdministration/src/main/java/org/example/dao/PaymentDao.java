package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PaymentDao {
    public static void createPayment(Payment payment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(payment);
            transaction.commit();
        }
    }

    public static Payment getPaymentById(long id) {
        Payment payment;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            payment = session.get(Payment.class, id);
            transaction.commit();
        }

        return payment;
    }

    public static void updatePayment(Payment payment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(payment);
            transaction.commit();
        }
    }

    public static void deletePayment(Payment payment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(payment);
            transaction.commit();
        }
    }
}
