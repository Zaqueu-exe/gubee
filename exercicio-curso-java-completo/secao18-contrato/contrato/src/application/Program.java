package application;

import model.entities.Contrato;
import model.services.ContratoService;
import model.services.Paypal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);


        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int number = scan.nextInt();
        System.out.print("Date (DD/MM/YYYY): ");
        String data =scan.next();
        System.out.print("Contract value: ");
        double valor = scan.nextDouble();
        System.out.print("Enter number of installments: ");
        int parcelas = scan.nextInt();

        Contrato contrato = new Contrato(number, valor, sdf.parse(data));
        ContratoService cs = new ContratoService(new Paypal());
        cs.processaContrato(contrato, parcelas);


        System.out.println("Installments: ");
        System.out.println(contrato);
    }
}
