package deborah.dbc;
import java.util.*;

public class Lista1Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a nota da primeira prova: ");
        float primeiraProva = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Digite a nota da segunda prova: ");
        float segundaProva = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Digite a nota da terceira prova: ");
        float terceiraProva = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Digite a nota da quarta prova: ");
        float quartaProva = scanner.nextFloat();
        scanner.nextLine();
        float mediaTotal = (primeiraProva + segundaProva + terceiraProva + quartaProva)/4;
        System.out.println("A média do aluno é: " + mediaTotal);
        if (mediaTotal >= 0 && mediaTotal <= 5){
            System.out.println("O aluno está reprovado.");
        }
        else if (mediaTotal >= 5.1 && mediaTotal <= 6.9){
            System.out.println("O aluno está de exame.");
        }
        else if (mediaTotal >= 7 && mediaTotal <= 10){
            System.out.println("O aluno está aprovado.");
        }
        else {
            System.out.println("Insira valores entre 0 e 10.");
        }

    }
}
