package br.com.alves.application;

import br.com.alves.entities.Conta;

import java.util.Locale;
import java.util.Scanner;
public class program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        Conta conta;

        System.out.print("Enter account number: ");
        int number = scan.nextInt();
        System.out.print("Enter account holder: ");
        String holder = scan.next();
        System.out.print("Is there an initial deposit (y/n)? ");
        String option = scan.next();

        if(option.equalsIgnoreCase("y")){
            System.out.print("Enter initial deposit value: ");
            double value = scan.nextDouble();
            conta = new Conta(number, holder, value);
        }else{
            conta = new Conta(number, holder);
        }

        System.out.println("Account data: ");
        System.out.println(conta);

        System.out.print("Enter a deposit value: ");
        double value = scan.nextDouble();
        conta.depositar(value);
        System.out.println("Account data: ");
        System.out.println(conta);

        System.out.print("Enter a withdraw value: ");
        value = scan.nextDouble();
        conta.sacar(value);
        System.out.println("Account data: ");
        System.out.println(conta);



        scan.close();
    }
}
