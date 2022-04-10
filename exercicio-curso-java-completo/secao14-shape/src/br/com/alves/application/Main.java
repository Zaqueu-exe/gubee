package br.com.alves.application;

import br.com.alves.entities.Circle;
import br.com.alves.entities.Rectangle;
import br.com.alves.entities.Shape;
import br.com.alves.entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        List<Shape> shapes = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int n = scan.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Shape #" + i + " data:");
            System.out.print("Rectangle or Circle (r/c)? ");
            char opt = scan.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            String color = scan.next();

            if(opt == 'r'){
                System.out.print("Width: ");
                double width = scan.nextDouble();
                System.out.print("Height: ");
                double height = scan.nextDouble();
                shapes.add(new Rectangle(Color.valueOf(color), width, height));
            }else{
                System.out.print("Radius: ");
                double radius = scan.nextDouble();
                shapes.add(new Circle(Color.valueOf(color), radius));
            }
        }
        System.out.println();
        System.out.println("SHAPE AREAS:");
        for(Shape s : shapes){
            System.out.println(String.format("%.2f", s.area()));
        }
    }
}
