package br.com.alves.application;

import br.com.alves.entities.Client;
import br.com.alves.entities.Order;
import br.com.alves.entities.OrderItem;
import br.com.alves.entities.Product;
import br.com.alves.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);
        Order order;
        Client client;
        OrderItem orderItem;

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String date = scan.nextLine();
        client = new Client(name, email, sdf.parse(date));

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = scan.nextLine();
        order = new Order(new Date(), OrderStatus.valueOf(status), client);

        System.out.print("How many items to this order? ");
        int n = scan.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("Enter #" + (i+1) + " item data: ");
            System.out.print("Product name: ");
            String proName = scan.next();
            System.out.print("Product price: ");
            Double price = scan.nextDouble();
            System.out.print("Quantity: ");
            Integer quantity = scan.nextInt();
            orderItem = new OrderItem(quantity, new Product(proName, price));
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println(order);

        scan.close();
    }
}
