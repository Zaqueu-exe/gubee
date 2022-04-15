package application;


import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrasilTaxService;
import model.services.RentalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");


        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String model = scan.nextLine();


        System.out.print("Pickup (DD/MM/YYYY HH:MM): ");
        String pickup = scan.nextLine();
        System.out.print("Return (DD/MM/YYYY HH:MM): ");
        String retur = scan.nextLine();

        CarRental cr = new CarRental(sdf.parse(pickup), sdf.parse(retur), new Vehicle(model));

        System.out.print("Enter price per hour: ");
        double priceHour = scan.nextDouble();
        System.out.print("Enter price per day: ");
        double priceDay = scan.nextDouble();

        RentalService rentalService = new RentalService(priceHour, priceDay, new BrasilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("INVOICE: ");
        System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().totalPayment()));
    }
}
