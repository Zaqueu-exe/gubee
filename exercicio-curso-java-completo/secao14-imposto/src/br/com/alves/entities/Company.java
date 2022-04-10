package br.com.alves.entities;

public class Company extends TaxPayer {
    private  Integer numeroFuncionarios;

    public Company(String name, Double rendaAnual, Integer numeroFuncionarios) {
        super(name, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double imposto() {
        double total = 0.0;
        if(this.numeroFuncionarios <= 10){
            total = super.getRendaAnual() * 0.16;
        }else{
            total = super.getRendaAnual() * 0.14;
        }
        return total;
    }
}
