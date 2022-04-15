package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcela {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date dueDate;
    private double amount;

    public Parcela(Date dueDate, double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return sdf.format(dueDate) + "- " + String.format("%.2f", amount);
    }
}
