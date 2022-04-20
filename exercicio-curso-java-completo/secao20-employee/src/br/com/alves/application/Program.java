package br.com.alves.application;

import br.com.alves.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter full file path: ");
        String path = scan.next();
        System.out.print("Enter salary: ");
        double salary = scan.nextDouble();
        System.out.println("Email of people whose salary is more than " + salary + ":");

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Employee> employees = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] aux = line.split(",");
                employees.add(new Employee(aux[0], aux[1], Double.parseDouble(aux[2])));
                line = br.readLine();
            }

            employees.stream()
                    .filter(e -> e.getSalary() > salary)
                    .map(e -> e.getEmail())
                    .sorted((e1, e2) -> e1.toUpperCase().compareTo(e2.toUpperCase()))
                    .forEach(System.out::println);

            double sum = employees.stream()
                    .filter(e -> e.getNome().charAt(0) == 'M')
                    .map(e -> e.getSalary())
                    .reduce(0.0, (x, y) -> x + y);

            System.out.println("Sum of salary of people whose name starts with 'M': " +sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
