package br.com.alves.entities;

public class ImpostoBebida implements Imposto{
    private static final double TAXA = 0.09;

    @Override
    public double valorImposto(double valor) {
        return valor*TAXA;
    }
}
