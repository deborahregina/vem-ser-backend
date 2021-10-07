package deborah.dbc;
import java.util.Scanner;

public class Lista2Exercicio3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String [] nomes = new String[100];
        double [] alturas = new double[100];
        int [] idades = new int[100];
        double [] pesos = new double[100];
        int i = 0;

        while(true) {
            System.out.flush();
            System.out.print("Digite o nome do jogador " + (i + 1) + ": ");
            nomes[i] = scanner.next();
            if (nomes[i].equalsIgnoreCase("Sair")) {
                break;
            }

            System.out.print("Digite a altura do jogador " + (i + 1) + ": ");
            alturas[i] = scanner.nextDouble();

            System.out.print("Digite a idade do jogador " + (i + 1) + ": ");
            idades[i] = scanner.nextInt();

            System.out.print("Digite o peso do jogador " + (i + 1) + ": ");
            pesos[i] = scanner.nextDouble();
            System.out.println("----------------------------------");
            i++;
        }

        double maiorAltura = alturas[0];
        int maiorIdade = idades[0];
        double maiorPeso = pesos[0];
        int indiceAltura = 0;
        int indiceIdade = 0;
        int indicePeso = 0;
        double somaAlturas = 0;

        for (int j = 0; j < i; j++) {
            if (alturas[j] > maiorAltura){ //Obter a altura máxima e onde ela ocorre
                maiorAltura = alturas[j];
                indiceAltura = j;
            }
            if (idades[j] > maiorIdade){ //Obter a idade maxima e onde ela ocorre
                maiorIdade = idades[j];
                indiceIdade = j;
            }
            if (pesos[j] > maiorPeso){ //obter maior peso e onde ele ocorre
                maiorPeso = pesos[j];
                indicePeso = j;
            }
            somaAlturas += alturas[j]; //somar alturas para calcular média
        }
        System.out.println("----------------------------------\nResultados\n----------------------------------");
        System.out.println("O número de jogadores é: "+i);
        System.out.println(String.format("A alturas do maior jogador é: %.2f",maiorAltura));
        System.out.println("O jogador mais velho é: "+nomes[indiceIdade]);
        System.out.println("O jogador mais pesado é: "+nomes[indicePeso]);
        System.out.println(String.format("A média de alturas dos jogadores é: %.2f",(somaAlturas/i)));
    }
}
