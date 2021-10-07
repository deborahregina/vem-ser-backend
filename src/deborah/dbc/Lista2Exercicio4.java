package deborah.dbc;
import java.util.Scanner;

public class Lista2Exercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numeros = new int[3];

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o elemento "+(i+1)+ " :");
            numeros[i] = scanner.nextInt();
        }
        int menorNumero = numeros[0];
        int posicaoMenorNumero = 0;
        for (int j = 0; j < numeros.length; j++){
            if (numeros[j] < menorNumero) {
                menorNumero = numeros[j];
                posicaoMenorNumero = j;
            }
        }
        System.out.println("O menor número digitado é "+menorNumero+ ", que é o "+(posicaoMenorNumero+1)+"º número, ocupando a posição "+posicaoMenorNumero +" do vetor");
    }

}
