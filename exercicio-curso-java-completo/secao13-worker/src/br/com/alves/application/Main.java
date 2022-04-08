package br.com.alves.application;

import br.com.alves.entities.Department;
import br.com.alves.entities.HourContract;
import br.com.alves.entities.Worker;
import br.com.alves.entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);
        Worker worker;
        HourContract hourContract;
        Department depart;

        System.out.print("Enter department's name: ");
        String department = scan.nextLine();
        depart = new Department(department);

        System.out.println("Enter worker data: ");

        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Level: ");
        String level = scan.nextLine();
        System.out.print("Base salary: ");
        Double salary = scan.nextDouble();
        worker = new Worker(name, WorkerLevel.valueOf(level), salary, depart);

        System.out.print("How many contracts to this worker? ");
        int contracts = scan.nextInt();

        for(int i = 0; i < contracts; i++) {
            System.out.println("Enter contract #" +(i+1) + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            String dateContract = scan.next();
            System.out.print("Value per hour: ");
            Double value = scan.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = scan.nextInt();

            hourContract = new HourContract(sdf.parse(dateContract), value, hours);
            worker.addContract(hourContract);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String dateCalc = scan.next();
        String[] dates = dateCalc.split("/");

        System.out.println(worker);
        System.out.println("Income for " + dateCalc + ": "+ String.format("%.2f", worker.income(Integer.parseInt(dates[1]), Integer.parseInt(dates[0]))));

        scan.close();
    }
}
