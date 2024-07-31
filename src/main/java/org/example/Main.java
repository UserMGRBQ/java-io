package org.example;

import org.example.model.entities.CarRental;
import org.example.model.entities.Vehicle;
import org.example.model.services.BrazilTaxService;
import org.example.model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();
        System.out.println("Retirada (dd/MM/yyyy hh:mm)");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.println("Entrega (dd/MM/yyyy hh:mm)");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Entre com o preco por hora");
        Double pricePerHour = sc.nextDouble();

        System.out.print("Entre com o preco por dia");
        Double pricePerDay = sc.nextDouble();

        RentalService rentalService =
                new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(carRental);

        System.out.println("Pagamento basico: " + carRental.getInvoice().getBasicPayment());
        System.out.println("Taxas: " + carRental.getInvoice().getTax());
        System.out.println("Pagamento total: " + carRental.getInvoice().getTotalPayment());

        sc.close();
    }
}
