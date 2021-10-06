package deborah.dbc;
import java.util.Scanner;

public class Lista2Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroCerto;
        int numeroTentativa;

        System.out.print("Digite o número da brincadeira: ");
        numeroCerto = scanner.nextInt();
        System.out.print("Tente adivinhar o número: ");
        numeroTentativa = scanner.nextInt();

        while(numeroCerto != numeroTentativa) {
            if (numeroTentativa > numeroCerto){
                System.out.println("O número digitado é maior que o número que queremos adivinhar.");
            }
            else {
                System.out.println("O número digitado é menor que o número que queremos adivinhar.");
            }
            System.out.print("Faça uma nova tentativa e digite um número: ");
            numeroTentativa = scanner.nextInt();
        }
        System.out.println("Você acertou!");
    }

}
