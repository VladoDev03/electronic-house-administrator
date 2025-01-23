package org.example.service.contracts;

import org.example.dto.Payment.CreatePaymentDto;
import org.example.dto.Payment.PaymentDto;
import org.example.dto.Payment.UpdatePaymentDto;
import org.example.exception.EntitiesAlreadyRelatedException;
import org.example.exception.EntityNotFoundException;

import java.util.List;

public interface PaymentService {
    PaymentDto getPaymentById(long paymentId) throws EntityNotFoundException;
    PaymentDto createPayment(CreatePaymentDto paymentDto);
    void updatePayment(UpdatePaymentDto paymentDto);
    void deletePayment(long paymentId) throws EntityNotFoundException;
    void addPaymentToApartment(long apartmentId, long paymentId) throws EntityNotFoundException, EntitiesAlreadyRelatedException;
    void createMultiplePayments(List<CreatePaymentDto> paymentDtos);
    void addMultiplePaymentsToBuilding(long buildingId) throws EntityNotFoundException, EntitiesAlreadyRelatedException;
    void savePaymentToFile(long paymentId) throws EntityNotFoundException;
}
