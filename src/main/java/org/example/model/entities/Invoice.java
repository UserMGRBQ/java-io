package org.example.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Invoice {
    private Double basicPayment;
    private Double tax;

    public Double getTotalPayment() {
        return getBasicPayment() + getTax();
    }
}
