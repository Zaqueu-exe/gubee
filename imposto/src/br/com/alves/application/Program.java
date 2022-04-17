package br.com.alves.application;

import br.com.alves.entities.*;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Detergente", 3.0, new ImpostoProdutoLimpeza()));
        produtos.add(new Produto("Carne", 28.0, new ImpostoAlimento()));
        produtos.add(new Produto("Console ps5", 4500.0, new ImpostoEletronico()));
        produtos.add(new Produto("cerveja", 5.0, new ImpostoBebida()));
        produtos.add(new Produto("Agua sanitaria", 4.0, new ImpostoProdutoLimpeza()));
        produtos.add(new Produto("Retrovisor", 10.0, new ImpostoPecaCarro()));
        produtos.add(new Produto("Pneu", 1000.0, new ImpostoPecaCarro()));
        produtos.add(new Produto("Notebook gamer", 7000.0, new ImpostoEletronico()));

        produtos.stream().forEach(System.out::println);
        System.out.println("----------------------");
        produtos.stream().filter(p -> p.getValor() > 1000.00).forEach(System.out::println);
        System.out.println("----------------------");
        produtos.stream().filter(p -> p.getNome().charAt(0) == 'C').forEach(System.out::println);
    }
}
