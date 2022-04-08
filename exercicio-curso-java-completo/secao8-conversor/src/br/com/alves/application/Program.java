package br.com.alves.application;

import java.util.Locale;
import java.util.Scanner;

/*
Faça um programa para ler a cotação do dólar, e depois um valor em dólares a ser comprado por
uma pessoa em reais. Informar quantos reais a pessoa vai pagar pelos dólares, considerando ainda
que a pessoa terá que pagar 6% de IOF sobre o valor em dólar. Criar uma classe CurrencyConverter
para ser responsável pelos cálculos.

 */
public class Program {

    public static double IOF = 0.06;

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        double price, quantity, amount;
        System.out.print("What is the dollar price? ");
        price = scan.nextDouble();
        System.out.print("How many dollars will be bought? ");
        quantity = scan.nextDouble();
        amount = currencyConverter(price, quantity);
        amount += amount*IOF;
        System.out.println("Amount to be paid in reais = " + String.format("%.2f", amount));

    }

    public static double currencyConverter(double price, double quantity){
        return price * quantity;
    }

}
