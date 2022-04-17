package br.com.alves.entities;

public class ImpostoPecaCarro implements  Imposto{
    private static final double TAXA = 0.30;

    @Override
    public double valorImposto(double valor) {
        return valor*TAXA;
    }
}
