package deborah.dbc;
import java.util.Scanner;

public class Lista2Exercicio1 {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String nomeProduto = new String();
    double precoProduto;
    double desconto;
        System.out.print("Digite o nome do produto: ");
        nomeProduto = scanner.next();
        System.out.print("Digite o valor do produto: ");
        precoProduto = scanner.nextDouble();
        System.out.println("Item: " + nomeProduto +"\nPreço unitário: " + precoProduto + "\nPromoção: " +nomeProduto);
        System.out.println("------------------------");
        for (int i = 1;i <= 10; i++) {
            desconto = precoProduto - precoProduto*0.05*i;
            System.out.println(String.format("%d X R$%.2f = %.2f",i,desconto,desconto*i));
        }
    }
}
