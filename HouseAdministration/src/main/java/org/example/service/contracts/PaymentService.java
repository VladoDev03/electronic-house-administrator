package org.example.service.contracts;

import org.example.dto.Payment.CreatePaymentDto;
import org.example.dto.Payment.PaymentDto;
import org.example.dto.Payment.UpdatePaymentDto;

public interface PaymentService {
    PaymentDto getPaymentById(long paymentId);
    PaymentDto createPayment(CreatePaymentDto paymentDto);
    void updatePayment(UpdatePaymentDto paymentDto);
    void deletePayment(long paymentId);
    void addPaymentToApartment(long apartmentId, long paymentId);
}
