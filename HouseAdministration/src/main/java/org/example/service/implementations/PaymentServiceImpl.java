package org.example.service.implementations;

import org.example.dao.ApartmentDao;
import org.example.dao.PaymentDao;
import org.example.dto.Payment.CreatePaymentDto;
import org.example.dto.Payment.PaymentDto;
import org.example.dto.Payment.UpdatePaymentDto;
import org.example.entity.Apartment;
import org.example.entity.Payment;
import org.example.service.contracts.PaymentService;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentDto getPaymentById(long paymentId) {
        Payment payment = PaymentDao.getPaymentById(paymentId);

        PaymentDto result = new PaymentDto(
                paymentId,
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getApartment()
        );

        return result;
    }

    @Override
    public PaymentDto createPayment(CreatePaymentDto paymentDto) {
        Payment payment = new Payment(
                paymentDto.getAmount(),
                paymentDto.getPaymentDate(),
                paymentDto.getApartment()
        );

        PaymentDao.createPayment(payment);

        PaymentDto result = new PaymentDto(
                payment.getId(),
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getApartment()
        );

        return result;
    }

    @Override
    public void updatePayment(UpdatePaymentDto paymentDto) {
        Payment payment = new Payment(
                paymentDto.getId(),
                paymentDto.getAmount(),
                paymentDto.getPaymentDate(),
                paymentDto.getApartment()
        );

        PaymentDao.updatePayment(payment);
    }

    @Override
    public void deletePayment(long paymentId) {
        Payment payment = PaymentDao.getPaymentById(paymentId);
        PaymentDao.deletePayment(payment);
    }

    @Override
    public void addPaymentToApartment(long apartmentId, long paymentId) {
        Payment payment = PaymentDao.getPaymentById(paymentId);
        Apartment apartment = ApartmentDao.getApartmentById(apartmentId);

        UpdatePaymentDto updatePaymentDto = new UpdatePaymentDto(
                payment.getId(),
                payment.getAmount(),
                payment.getPaymentDate(),
                apartment
        );

        updatePayment(updatePaymentDto);
    }
}
