package br.com.alves.entities;

public class ImportedProduct extends Product {
    private Double customsfee;

    public ImportedProduct(String name, Double price, Double customsfee) {
        super(name, price);
        this.customsfee = customsfee;
    }

    public Double getCustomsfee() {
        return customsfee;
    }

    public void setCustomsfee(Double customsfee) {
        this.customsfee = customsfee;
    }

    public double totalPrice() {
        return super.getPrice() + customsfee;
    }

    @Override
    public String priceTag() {
        return name + " - $ " + String.format("%.2f", totalPrice() )+ "( Customs fee: $ " + String.format("%.2f", getCustomsfee()) + ")";
    }
}
