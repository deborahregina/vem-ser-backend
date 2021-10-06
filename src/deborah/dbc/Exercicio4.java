package deborah.dbc;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Rio Grande do Sul \n"+"2- Minas Gerais \n"+"3- Pernambuco \n" );
        System.out.println("Escolha um estado: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        int escolhaCidade = 0;

        switch (escolha) {

            case 1:
                System.out.print("1- Porto Alegre \n"+"2- Caxias do Sul \n");
                System.out.println("Escolha a cidade: ");
                escolhaCidade = scanner.nextInt();
                scanner.nextLine();
                if (escolhaCidade == 1) {
                    System.out.println("Dados de Porto Alegre: \nPopulação 1 492 530\nIDH 0,805.");
                }
                else if (escolhaCidade == 2) {
                    System.out.println("Dados de Caxias do Sul: \nPopulação 517 451\nIDH0,782. ");
                }
                else {
                    System.out.println("Digite uma opção válida.");
                }
                break;

            case 2:
                System.out.print("1- Belo Horizonte\n"+"2- Ouro Preto \n");
                System.out.println("Escolha a cidade: ");
                escolhaCidade = scanner.nextInt();
                scanner.nextLine();
                if (escolhaCidade == 1) {
                    System.out.println("Dados de Belo Horizonte: \nPopulação 2 530 701\nIDH 0,810.");
                }
                else if (escolhaCidade == 2) {
                    System.out.println("Dados de Ouro Preto: \nPopulação 73 994\nIDH 0,741.");
                }
                else {
                    System.out.println("Digite uma opção válida.");
                }
                break;

            case 3:
                System.out.print("1- Recife\n"+"2- Olinda \n");
                System.out.println("Escolha a cidade: ");
                escolhaCidade = scanner.nextInt();
                scanner.nextLine();
                if (escolhaCidade == 1) {
                    System.out.println("Dados de Recife: \nPopulação 1 661 017\nIDH 0,772.");
                }
                else if (escolhaCidade == 2) {
                    System.out.println("Dados de Olinda: \nPopulação 393 115\nIDH 0,735.");
                }
                else {
                    System.out.println("Digite uma opção válida.");
                }
                break;
            default:
                System.out.println("Digite uma opção válida.");
                break;

        }


    }
}
