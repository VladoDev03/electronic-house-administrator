package org.example.service.implementations;

import org.example.dao.ApartmentDao;
import org.example.dao.PaymentDao;
import org.example.dto.Payment.CreatePaymentDto;
import org.example.dto.Payment.NewPaymentDto;
import org.example.dto.Payment.PaymentDto;
import org.example.dto.Payment.UpdatePaymentDto;
import org.example.entity.Apartment;
import org.example.entity.Payment;
import org.example.service.contracts.BuildingService;
import org.example.service.contracts.PaymentService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    private final BuildingService buildingService;

    public PaymentServiceImpl(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

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
        savePaymentToFile(paymentId);
    }

    @Override
    public void createMultiplePayments(List<CreatePaymentDto> paymentDtos) {
        PaymentDao.createMultiplePayments(
                paymentDtos
                        .stream()
                        .map(p -> {
                            Payment payment = new Payment(
                                    p.getAmount(),
                                    p.getPaymentDate(),
                                    p.getApartment()
                            );

                            return payment;
                        })
                        .toList()
        );
    }

    @Override
    public void addMultiplePaymentsToBuilding(long buildingId) {
        for (NewPaymentDto payment : buildingService.createPayments(buildingId)) {
            CreatePaymentDto newPayment = new CreatePaymentDto(
                    payment.getAmount(),
                    null
            );

            PaymentDto addedPayment = createPayment(newPayment);
            addPaymentToApartment(payment.getApartmentId(), addedPayment.getId());
        }
    }

    @Override
    public void savePaymentToFile(long paymentId) {
        Payment payment = PaymentDao.getPaymentById(paymentId);

        String folderName = "uploads";

        File uploadsFolder = new File(folderName);

        if (!uploadsFolder.exists()) {
            uploadsFolder.mkdir();
        }

        String fileName = folderName + File.separator + String.valueOf(payment.getId()) + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("===== Payment Info =====");
            writer.newLine();
            writer.write("========================");
            writer.newLine();
            writer.write(payment.toString());
        } catch (IOException ignored) {
        }
    }
}
