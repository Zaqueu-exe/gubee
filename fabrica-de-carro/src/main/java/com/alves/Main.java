package com.alves;

import java.util.Arrays;
import java.util.List;

import com.alves.entity.veiculoAbstrato.BicicletaAbstrata;
import com.alves.entity.veiculoAbstrato.CarroAbstrato;
import com.alves.fabrica.enums.TipoFabrica;

public class Main {
    public static void main(String[] args) {

        var luxoFactory = Init.criarFabrica(TipoFabrica.LUXO);
        var popularFactory = Init.criarFabrica(TipoFabrica.POPULAR);
        var superLuxoFactory = Init.criarFabrica(TipoFabrica.SUPERLUXO);

        List<BicicletaAbstrata> bicicletas = Arrays.asList(
            luxoFactory.criarBicicleta(),
            popularFactory.criarBicicleta(),
            superLuxoFactory.criarBicicleta()
        );
    
        
        List<CarroAbstrato> carros = Arrays.asList(
            luxoFactory.criarCarro(),
            popularFactory.criarCarro(),
            superLuxoFactory.criarCarro()
        );

        System.out.println("Familia bicicleta com suas variantes: \n");
        bicicletas.stream().map(x -> x.descricao()).forEach(System.out::println);

        System.out.println("---------------------------------\n");

        System.out.println("Familia carro com suas variantes: \n");
        carros.stream().map(x -> x.descricao()).forEach(System.out::println);
    }
}
