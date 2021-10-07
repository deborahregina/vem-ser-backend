package deborah.dbc;
import java.util.Scanner;

public class Lista2Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numerosInteiros = new int[20];

        for (int i = 0; i < numerosInteiros.length; i++) {
            System.out.print("Digite o número "+(i+1)+" do vetor: ");
            numerosInteiros[i] = scanner.nextInt();
        }
        System.out.println("--------------------------");
        System.out.println("Imprimindo ao contrário: ");

        int j = numerosInteiros.length - 1;

        do {
            System.out.println(numerosInteiros[j]);
            j--;
        } while (j != -1);

        }

    }


