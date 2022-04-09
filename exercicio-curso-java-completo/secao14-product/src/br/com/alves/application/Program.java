package br.com.alves.application;

import br.com.alves.entities.ImportedProduct;
import br.com.alves.entities.Product;
import br.com.alves.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = scan.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char opt = scan.next().charAt(0);
            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("Price: ");
            double price = scan.nextDouble();;

            if(opt == 'i'){
                System.out.print("Customs fee: ");
                double fee = scan.nextDouble();
                products.add(new ImportedProduct(name, price, fee));
            }else if(opt == 'c'){
                products.add(new Product(name, price));
            }else if(opt == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String date = scan.next();
                products.add(new UsedProduct(name, price, sdf.parse(date)));
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product p : products){
            System.out.println(p.priceTag());
        }
    }
}
