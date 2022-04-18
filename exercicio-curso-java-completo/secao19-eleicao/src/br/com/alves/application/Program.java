package br.com.alves.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
formato do arquivo lido

nome,qtdVotos
 */
public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter file ");
        String path = scan.next();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            Map<String, Integer> candidatos = new HashMap<>();

            String line = br.readLine();
            while (line!= null){
                String[] aux = line.split(",");
                String nome = aux[0];
                int qtdVotos = Integer.parseInt(aux[1]);

                if(candidatos.containsKey(nome)){
                    int votos = candidatos.get(nome) + qtdVotos;
                    candidatos.put(nome, votos);
                }else{
                    candidatos.put(nome, qtdVotos);
                }
                line = br.readLine();
            }

            for(String key : candidatos.keySet()){
                System.out.println(key + ": " + candidatos.get(key));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
