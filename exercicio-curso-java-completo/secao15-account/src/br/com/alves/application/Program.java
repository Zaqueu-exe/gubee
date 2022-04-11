package br.com.alves.application;

import br.com.alves.model.entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        try{
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = scan.nextInt();
            System.out.print("Holder: ");
            scan.nextLine();
            String holder = scan.nextLine();
            System.out.print("Initial balance: ");
            double balance = scan.nextDouble();
            System.out.print("Withdraw limit: ");
            double limit = scan.nextDouble();

            Account account = new Account(number, holder, balance, limit);

            System.out.print("Enter amount for withdraw: ");
            double withdraw = scan.nextDouble();
            account.withdraw(withdraw);

            System.out.print("New balance: " + String.format("%.2f",account.getBalance()));

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        scan.close();
    }
}
