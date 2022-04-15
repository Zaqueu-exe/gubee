package model.services;

public interface ServicePayment {

    public double valorParcela(int parcela, double valor);

    public double taxaPagamento(double amount);
}
