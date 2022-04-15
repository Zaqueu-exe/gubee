package model.services;

import model.entities.CarRental;
import model.entities.Invoice;
import model.services.BrasilTaxService;

public class RentalService {

    private double pricePerHour;
    private double pricePerDay;
    private TaxService taxService;

    public RentalService(double pricePerHour, double pricePerDay, TaxService TaxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void processInvoice(CarRental carRental) {
        long t1 = carRental.getState().getTime();
        long t2 = carRental.getFinish().getTime();
        double hours = (double) (t2 - t1) / 1000 / 60 / 60;
        double basicPayment;
        if(hours <= 12){
            basicPayment = Math.ceil(hours)*pricePerHour;
        }else{
            basicPayment = Math.ceil(hours/24)*pricePerDay;
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
