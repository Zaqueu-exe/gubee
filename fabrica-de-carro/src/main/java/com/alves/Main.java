package com.alves;

import com.alves.entity.carroAbstrato.CarroAbstrato;
import com.alves.fabrica.FabricaAbstrata;
import com.alves.fabrica.enums.TipoCarro;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        var popular = FabricaAbstrata.escolherTipo(TipoCarro.POPULAR).criarCarro();
        var luxo = FabricaAbstrata.escolherTipo(TipoCarro.LUXO).criarCarro();
        var superLuxo = FabricaAbstrata.escolherTipo(TipoCarro.SUPERLUXO).criarCarro();

        List<CarroAbstrato> garagen = Arrays.asList(popular, luxo, superLuxo);
        garagen.stream().map(x -> x.descricao()).forEach(System.out::println);
    }
}