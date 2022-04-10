package br.com.alves.entities;

public class Individual extends TaxPayer {
    private Double gastoSaude;

    public Individual(String name, Double rendaAnual, Double gastoSaude) {
        super(name, rendaAnual);
        this.gastoSaude = gastoSaude;
    }

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    @Override
    public double imposto() {
        Double total = 0.0;
        if(super.getRendaAnual() < 20.000){
            total = super.getRendaAnual() * 0.15;
        }else{
            total = super.getRendaAnual() * 0.25;
        }

        if(this.gastoSaude > 0){
            total -= this.gastoSaude * 0.5;
        }
        return total;
    }
}
