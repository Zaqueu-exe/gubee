package br.com.alves.entities;

public class ImpostoProdutoLimpeza implements Imposto{
    private static final double TAXA = 0.15;

    @Override
    public double valorImposto(double valor) {
        return valor*TAXA;
    }
}
