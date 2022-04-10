package br.com.alves.application;

import br.com.alves.entities.TaxPayer;
import br.com.alves.entities.Individual;
import br.com.alves.entities.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = scan.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char opt = scan.next().charAt(0);
            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("Anual income: ");
            double income = scan.nextDouble();

            if(opt == 'i'){
                System.out.print("Health expenditures: ");
                double health = scan.nextDouble();
                taxPayers.add(new Individual(name, income, health));
            }else if(opt == 'c'){
                System.out.print("Number of employees: ");
                int employees = scan.nextInt();
                taxPayers.add(new Company(name, income, employees));
            }

        }
        System.out.println();
        System.out.println("TAXES PAID:");
        double total = 0.0;
        for(TaxPayer p : taxPayers){
            System.out.println(p.getName() + ": $ " + String.format("%.2f", p.imposto()));
            total += p.imposto();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", total));

        scan.close();
    }
}
