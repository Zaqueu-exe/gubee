package model.services;

public class Paypal implements ServicePayment {
    private static final double TAXA = 0.02;
    private static final double TAXA_MENSAL = 0.01;

    @Override
    public double taxaPagamento(double amount) {
        return amount *TAXA;

    }
    @Override
    public double valorParcela(int parcela, double amount) {
        return amount * TAXA_MENSAL * parcela;
    }


}
