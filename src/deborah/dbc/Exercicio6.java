package deborah.dbc;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a palavra que deseja traduzir: ");
        String palavra = scanner.nextLine();

        if (palavra.equalsIgnoreCase("Cachorro")){
            System.out.println("A tradução de " +palavra+ " é \"Dog\".");
        }
        else if (palavra.equalsIgnoreCase("Dog")){
            System.out.println("A tradução de " +palavra+ " é \"Cachorro\".");
        }
        else if (palavra.equalsIgnoreCase("Tempo")){
            System.out.println("A tradução de " +palavra+ " é \"Time\".");
        }
        else if (palavra.equalsIgnoreCase("Time")){
            System.out.println("A tradução de " +palavra+ " é \"Tempo\".");
        }
        else if (palavra.equalsIgnoreCase("Amor")){
            System.out.println("A tradução de " +palavra+ " é \"Love\".");
        }
        else if (palavra.equalsIgnoreCase("Love")){
            System.out.println("A tradução de " +palavra+ " é \"Amor\".");
        }
        else if (palavra.equalsIgnoreCase("Cidade")){
            System.out.println("A tradução de " +palavra+ " é \"City\".");
        }
        else if (palavra.equalsIgnoreCase("City")){
            System.out.println("A tradução de " +palavra+ " é \"Cidade\".");
        }
        else if (palavra.equalsIgnoreCase("Feliz")){
            System.out.println("A tradução de " +palavra+ " é \"Happy\".");
        }
        else if (palavra.equalsIgnoreCase("Happy")){
        System.out.println("A tradução de " +palavra+ " é \"Feliz\".");
    }
        else {
            System.out.println("Essa palavra não é válida.");
        }
    }
}
