package deborah.dbc;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite sua cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Digite seu estado: ");
        String estado = scanner.nextLine();

        System.out.println(String.format("Seu nome é %s, você tem %d anos, é da cidade de %s, no estado de %s.", nome, idade, cidade, estado));
    }
}
