package br.com.alves.application;

import br.com.alves.entities.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter full file path: ");
        String path = scan.next();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Produto> produtos = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] aux = line.split(",");
                produtos.add(new Produto(aux[0], Double.parseDouble(aux[1])));
                line = br.readLine();
            }

            double media = produtos.stream()
                    .map(p -> p.getPreco())
                    .reduce(0.0, (x, y) -> x + y) / produtos.size();

            System.out.println("Average price: " + String.format("%.2f", media));

            /*Comparator<String> comp = (p1, p2) -> p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase());
            List<String> nomes = produtos.stream()
                    .filter(p -> p.getPreco() < media)
                    .map(p -> p.getNome())
                    .sorted(comp.reversed())
                    .collect(Collectors.toList());*/

            produtos.stream()
                    .filter(p -> p.getPreco() < media)
                    .map(p -> p.getNome())
                    .sorted((s1, s2) -> -s1.toUpperCase().compareTo(s2.toUpperCase()))
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
