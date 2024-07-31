package org.example.model.services;

import lombok.AllArgsConstructor;
import org.example.model.entities.CarRental;
import org.example.model.entities.Invoice;
import org.example.model.interfaces.TaxService;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
public class RentalService {

    private Double pricePerDay;
    private Double pricePerHour;
    private TaxService taxService;

    public void processInvoice(CarRental carRental) {

        Duration duration = Duration.between(carRental.getStart(), carRental.getFinish());
        Long minutes = duration.toMinutes();
        Long hours = minutes / 60;

        Double basicPayment;
        if (hours <= 12.0)
            basicPayment = pricePerHour * Math.ceil(hours);
        else
            basicPayment = pricePerDay * Math.ceil(hours / 24.0);

        Double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment,tax));
    }
}
