package deborah.regs.dbc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Integer [] numeros = new Integer[3];

        Scanner scanner = new Scanner(System.in);
        int posicaoMenorNumero = 0;
        for (int i = 0; i < numeros.length; i++ ) {
            System.out.println("Digite um número: ");
            numeros[i] = scanner.nextInt();
        }
    Integer menorNumero = numeros[0];
        for (int j = 0; j < numeros.length; j++ ) {
            if (menorNumero >= numeros[j]) {
                posicaoMenorNumero = j + 1;
            }
        }
        System.out.println("O menor número é o "+(posicaoMenorNumero)+"º digitado.");
    }
}
