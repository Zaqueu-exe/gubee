package model.entities;

import java.util.Date;

public class CarRental {
    private Date state;
    private Date finish;
    private  Vehicle vehicle;
    private Invoice invoice;
    public CarRental() {
    }

    public CarRental(Date state, Date finish, Vehicle vehicle) {
        this.state = state;
        this.finish = finish;
        this.vehicle = vehicle;
    }

    public Date getState() {
        return state;
    }

    public Date getFinish() {
        return finish;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
