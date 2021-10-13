import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade da pessoa: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a cidade da pessoa: ");
        String cidade = scanner.nextLine();
        System.out.print("Digite o estado da pessoa: ");
        String estado = scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome,idade,cidade,estado);
        System.out.println(pessoa.toString());
    }
}
