package br.com.alves.entities;

public class Conta {

    private int account;
    private String holder;
    private double saldo;

    public Conta(int account, String titular, double saldo){
        if(saldo < 0.0){
            throw new IllegalArgumentException("Saldo invalido");
        }
        this.account = account;
        this.holder = titular;
        this.saldo = saldo;
    }

    public Conta(int account, String titular) {
        this.account = account;
        this.holder = titular;
    }

    public int getAccount() {
        return account;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void sacar(double valor){
        if(valor <0.0 || saldo < valor){
            throw new IllegalArgumentException("Valor de saque invalido");
        }
        saldo -= valor + 5.0;
    }

    public void depositar(double valor){
        if(valor <0.0){
            throw new IllegalArgumentException("Valor de saque invalido");
        }
        saldo += valor;
    }

    @Override
    public String toString() {
        return "Account " + account +
                ", Holder " + holder +
                ", Balance: $ " + String.format("%.2f", saldo);
    }
}
