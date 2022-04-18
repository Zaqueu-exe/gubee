package br.com.alves.application;

import br.com.alves.entities.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*formato de arquivo lido

alex86 2018-08-26T20:45:08Z
bobbrown 2018-08-26T20:45:08Z
 */
public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Set<Log> hashSet = new HashSet<>();
        System.out.print("Enter file full path: ");
        String path = scan.next();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] aux = line.split(" ");
                try {
                    hashSet.add(new Log(aux[0], sdf.parse(aux[1])));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total users: " + hashSet.size());
    }
}
