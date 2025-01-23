package org.example.dao;

import jakarta.validation.Valid;
import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Payment;
import org.example.exception.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PaymentDao {
    public static void createPayment(@Valid Payment payment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(payment);
            transaction.commit();
        }
    }

    public static Payment getPaymentById(long id) throws EntityNotFoundException {
        Payment payment;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            payment = session.get(Payment.class, id);
            transaction.commit();
        }

        if (payment == null) {
            throw new EntityNotFoundException(id);
        }

        return payment;
    }

    public static void updatePayment(@Valid Payment payment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(payment);
            transaction.commit();
        }
    }

    public static void deletePayment(@Valid Payment payment) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(payment);
            transaction.commit();
        }
    }

    public static void createMultiplePayments(List<Payment> payments) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            
            for (Payment payment : payments) {
                session.persist(payment);
            }

            transaction.commit();
        }
    }
}
