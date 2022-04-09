package br.com.alves.application;

import br.com.alves.entitites.Employee;
import br.com.alves.entitites.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        Employee employee;
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1) + " data:");
            System.out.print("Outsourced (y/n)? ");
            String opt = scan.next();
            System.out.print("Name: ");
            String name = scan.next();
            System.out.print("Hours: ");
            int hour = scan.nextInt();
            System.out.print("Value per hour: ");
            double value = scan.nextDouble();

            if(opt.equalsIgnoreCase("y")){
                System.out.print("Additional charge: ");
                double additional = scan.nextDouble();

                employee = new OutsourcedEmployee(name,hour, value, additional);
                employees.add(employee);
            }else{
                employee = new Employee(name,hour, value);
                employees.add(employee);
            }

        }
        System.out.println();
        System.out.println("PAYMENTS:");
        for (Employee p : employees){
            System.out.println(p);
        }
    }
}
