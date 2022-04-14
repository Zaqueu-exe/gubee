import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entre com o caminho do arquivo");
        String strPath = scan.nextLine();
        File path = new File(strPath);
        boolean sucesso = new File(path.getParent() + "/out").mkdir();

        try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
            String line = br.readLine();
            while ((line != null)) {
                String[] aux = line.split(",");
                String nomeProduto = aux[0];
                double preco = Double.parseDouble(aux[1]);
                int quantidade = Integer.parseInt(aux[2]);
                double precoTotal = preco * quantidade;

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.getParent() + "/out/summary.csv", true))) {
                    bw.write(nomeProduto);
                    bw.write(",");
                    bw.write(String.valueOf(precoTotal));
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}