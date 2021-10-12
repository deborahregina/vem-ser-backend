package deborah.regs.dbc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean certo = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int numeroDigitado = scanner.nextInt();

        Tentativa tentativa = new Tentativa(numeroDigitado);


        while(certo == false) {

            System.out.println("Tente adivinhar: ");
            numeroDigitado = scanner.nextInt();
            certo = tentativa.acertou(numeroDigitado);
            tentativa.comparaNumero(numeroDigitado);
            if (tentativa.acertou(numeroDigitado)) {
                System.out.println("Você acertou!");
                break;
            }
        }

    }
}
