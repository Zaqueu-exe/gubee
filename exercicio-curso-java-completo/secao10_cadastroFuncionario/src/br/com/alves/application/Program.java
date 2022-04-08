package br.com.alves.application;

import br.com.alves.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (1 + i) + ":");
            System.out.print("Id: ");
            int id = scan.nextInt();
            while (hashId(employees, id)) {
                System.out.print("Id is in using, put another one: ");
                id = scan.nextInt();
            }
            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("Salary: ");
            double salary = scan.nextDouble();
            employees.add(new Employee(id, name, salary));
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int idEmployee = scan.nextInt();
        Employee employeeFound = employees.stream().filter(x -> x.getId() == idEmployee).findFirst().orElse(null);
        if(employeeFound == null){
            System.out.println("This Id doesn't exist!");
        }else {
            System.out.print("Enter the percentage: ");
            double percentage = scan.nextDouble();
            employeeFound.increaseSalary(percentage);
        }

        for(Employee employee : employees){
            System.out.println(employee);
        }
    }

    public static boolean hashId(List<Employee> list, int id) {
        Employee employee = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return employee != null;
    }
}
