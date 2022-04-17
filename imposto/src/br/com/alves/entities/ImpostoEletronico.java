package br.com.alves.entities;

public class ImpostoEletronico implements Imposto{
    private static final double TAXA = 0.40;

    @Override
    public double valorImposto(double valor) {
        return valor*TAXA;
    }
}
