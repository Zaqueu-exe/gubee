package br.com.alves.application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Integer> courseA = new HashSet<>();
        Set<Integer> courseB = new HashSet<>();
        Set<Integer> courseC = new HashSet<>();
        Set<Integer> totalStudents = new HashSet<>();

        System.out.print("How many students for course A? ");
        int cA = scan.nextInt();
        for(int i = 0; i < cA; i++){
            courseA.add(scan.nextInt());
        }

        System.out.print("How many students for course B? ");
        int cB = scan.nextInt();
        for(int i = 0; i < cB; i++){
            courseA.add(scan.nextInt());
        }

        System.out.print("How many students for course C? ");
        int cC = scan.nextInt();
        for(int i = 0; i < cC; i++){
            courseA.add(scan.nextInt());
        }

        totalStudents.addAll(courseA);
        totalStudents.addAll(courseB);
        totalStudents.addAll(courseC);

        System.out.println("Total students: "+ totalStudents.size());
        scan.close();
    }
}
