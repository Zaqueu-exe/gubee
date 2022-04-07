package br.com.alves.application;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = scan.nextInt();
            }
        }
        int number = scan.nextInt();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == number) {
                    System.out.println("Position " + i + "," + j + ":");
                    if (j - 1 >= 0) {
                        System.out.println("LEFT: " + mat[i][j-1]);
                    }
                    if (j + 1 < mat[i].length) {
                        System.out.println("RIGHT: " + mat[i][j+1]);
                    }
                    if (i - 1 >= 0) {
                        System.out.println("UP: " + mat[i-1][j]);
                    }
                    if (i + 1 < mat.length) {
                        System.out.println("DOWN: " + mat[i+1][j]);
                    }
                }
            }
        }
    }
}
