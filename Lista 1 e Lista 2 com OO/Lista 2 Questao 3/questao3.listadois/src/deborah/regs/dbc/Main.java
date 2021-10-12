package deborah.regs.dbc;

import java.text.DecimalFormat;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        Scanner scanner = new Scanner(System.in);
        String nome = "";
        int numjogador = 0;
        double altura;
        int idade;
        double peso;
        double maiorAltura = 0;
        double somaAlturas = 0;
        int maiorIdade = 0;
        double maiorPeso = 0;
        String jogadorVelho= "";
        String jogadorPesado = "";
        double mediaAlturas = 0;

        while(true) {
            System.out.flush();
            System.out.print("Digite o nome do jogador " + (numjogador + 1) + ": ");
            nome = scanner.next();
            if (nome.equalsIgnoreCase("Sair")) {
                break;
            }

            System.out.print("Digite a altura do jogador " + (numjogador + 1) + ": ");
            altura = scanner.nextDouble();
            somaAlturas += altura;
            if (maiorAltura < altura) {
                maiorAltura = altura;
            }
            System.out.print("Digite a idade do jogador " + (numjogador + 1) + ": ");
            idade = scanner.nextInt();
            if (maiorIdade < idade) {
                maiorIdade = idade;
                jogadorVelho = nome;
            }

            System.out.print("Digite o peso do jogador " + (numjogador + 1) + ": ");
            peso = scanner.nextDouble();
            if (maiorPeso < peso) {
                maiorPeso = peso;
                jogadorPesado = nome;
            }
            System.out.println("----------------------------------");
            numjogador++;

            Jogador jogador = new Jogador(nome,altura,idade,peso);

        }
        System.out.println("Número de jogadores: " + (numjogador) + "\nAltura do maior jogador: " + maiorAltura + "\nNome do jogador mais velho: " +jogadorVelho + "\nNome do jogador mais pesado: "+jogadorPesado + "\nMédia de alturas: "+ (df.format(somaAlturas/numjogador)));

    }
}
