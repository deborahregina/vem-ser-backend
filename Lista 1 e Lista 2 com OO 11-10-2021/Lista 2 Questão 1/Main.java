package deborah.regs.dbc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o valor do produto: ");
        double valor = scanner.nextDouble();

        Produto produto = new Produto(nome,valor,0.5);

        produto.aplicaDesconto();

    }
}
