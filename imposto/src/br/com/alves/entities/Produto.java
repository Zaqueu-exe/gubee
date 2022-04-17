package br.com.alves.entities;

public class Produto {
    private String nome;
    private Imposto imposto;
    private double valor;

    public Produto(String nome,double valor, Imposto imposto) {
        this.nome = nome;
        this.valor = valor;
        this.imposto = imposto;
    }

    public String getNome() {
        return nome;
    }

    public Imposto getImposto() {
        return imposto;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Imposto cobrado: " + String.format("%.2f", imposto.valorImposto(this.valor));
    }
}
