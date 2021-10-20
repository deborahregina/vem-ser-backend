package deborah.dbc;
import java.util.Scanner;

public class Aula2ExercicioPratico3 {
    public static void main(String[] args) {
        int tamanhoVetor;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de elementos do vetor: ");
        tamanhoVetor = scanner.nextInt();

        int [] numerosInteiros = new int[tamanhoVetor];
        int soma = 0;

        for (int i = 0;i<tamanhoVetor;i++) {
            System.out.print("Digite o elemento "+(i+1)+" do vetor: ");
            numerosInteiros[i] = scanner.nextInt();
            scanner.nextLine();
            soma += numerosInteiros[i];
        }

        System.out.println("A soma dos elementos é: "+soma+"\nA média dos elementos é: "+(double) soma/tamanhoVetor);
    }
}
