package com.alves.pedido.config;

import com.alves.pedido.Domain.Pedido;
import com.alves.pedido.Domain.PedidoItem;
import com.alves.pedido.Domain.Pessoa;
import com.alves.pedido.Domain.Produto;
import com.alves.pedido.repository.PedidoItemRepository;
import com.alves.pedido.repository.PedidoRepository;
import com.alves.pedido.repository.PessoaRepository;
import com.alves.pedido.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {

        pessoaRepository.deleteAll();
        produtoRepository.deleteAll();
        pedidoItemRepository.deleteAll();
        pedidoRepository.deleteAll();


        Pessoa p1 = new Pessoa(null, "Jose", "jose@gmail.com", "5599994444");
        Pessoa p2 = new Pessoa(null, "Paulo", "paulo@gmail.com", "5599994444");
        Pessoa p3 = new Pessoa(null, "Pedro", "pedro@gmail.com", "5599994444");

        Produto pro1 = new Produto(null, "Bolacha", 5.50);
        Produto pro2 = new Produto(null, "Feijão", 8.80);
        Produto pro3 = new Produto(null, "Pizza", 55.50);

        pessoaRepository.saveAll(Arrays.asList(p1, p2, p3));
        produtoRepository.saveAll(Arrays.asList(pro1, pro2, pro3));

        PedidoItem pe1 = new PedidoItem(null, pro1, 5);
        PedidoItem pe2 = new PedidoItem(null, pro2, 2);
        PedidoItem pe3 = new PedidoItem(null, pro3, 3);

        pedidoItemRepository.saveAll(Arrays.asList(pe1,pe2,pe3));

        Pedido p = new Pedido(null, Arrays.asList(pe2, pe1));

        pedidoRepository.save(p);

        p1.setPedido(p);

        pessoaRepository.save(p1);
    }
}
