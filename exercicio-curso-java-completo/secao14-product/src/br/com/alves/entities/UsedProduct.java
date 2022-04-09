package br.com.alves.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date manufacture;

    public UsedProduct(String name, Double price, Date manufacture) {
        super(name, price);
        this.manufacture = manufacture;
    }

    public Date getManufacture() {
        return manufacture;
    }

    @Override
    public String priceTag(){
        return name + "(used) $ " + String.format("%.2f", getPrice()) + "(Manufacture date: " + sdf.format(manufacture) + ")";
    }


}
