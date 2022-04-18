import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        int numeroIn = scan.nextInt();

        int numero = (int) (Math.random()*1000);
        if(numero > numeroIn){
            System.out.println("Numero digitado inferior");
        }else if(numeroIn > numero){
            System.out.println("Numero digitado maior");
        }else{
            System.out.println("Acertou");
        }
        System.out.println(numero);
    }
}