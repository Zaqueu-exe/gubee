package br.com.alves.entities;

public class ImpostoAlimento implements Imposto{
    private static final double TAXA = 0.10;

    @Override
    public double valorImposto(double valor) {
        return valor*TAXA;
    }
}
