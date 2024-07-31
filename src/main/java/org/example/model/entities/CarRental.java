package org.example.model.entities;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class CarRental {
    private LocalDateTime start;
    private LocalDateTime finish;

    private Vehicle vehicle;
    private Invoice invoice;

    public CarRental(
            LocalDateTime start,
            LocalDateTime finish,
            Vehicle vehicle
    ) {
        this.start = start;
        this.finish = finish;
        this.vehicle = vehicle;
    }
}
