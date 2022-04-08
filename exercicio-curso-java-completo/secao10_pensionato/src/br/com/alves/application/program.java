package br.com.alves.application;

import br.com.alves.entities.Pensionato;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many rooms will be rented? ");
        int n = scan.nextInt();
        Pensionato[] vect = new Pensionato[10];

        for(int i = 0; i < n; i++){
            System.out.println("Rent #" + (i+1) + ":");
            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("Email: ");
            String email = scan.nextLine();
            System.out.print("Room: ");
            int room = scan.nextInt();
            vect[room] = new Pensionato(name, email, room);
            System.out.println("");
        }

        System.out.println("Busy rooms: ");
        for(int i = 0; i < vect.length; i++){
            Pensionato room = vect[i];
            if(room != null){
                System.out.println(room);
            }
        }

        scan.close();
    }
}
