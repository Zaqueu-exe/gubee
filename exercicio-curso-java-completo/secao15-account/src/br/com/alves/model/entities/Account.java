package br.com.alves.model.entities;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        if(balance < 0.0 || withdrawLimit < 0.0){
            throw new IllegalArgumentException("Erro: Valor de saldo inicial ou limite negativo");
        }
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }


    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(Double amount){
        if(amount < 0.0){
            throw new IllegalArgumentException("Erro: Valor de deposito negativo");
        }
        balance += amount;
    }

    public void withdraw(Double amount){
        if(amount < 0.0){
            throw new IllegalArgumentException("Erro: Valor de saque negativo");
        }else if(amount > this.balance){
            throw  new IllegalArgumentException("Erro: Valor de Saque maior que o saque disponivel");
        }
        else if(amount > this.withdrawLimit){
            throw  new IllegalArgumentException("Erro: Valor de Saque maior que o limite");
        }
        balance -= amount;
    }
}
