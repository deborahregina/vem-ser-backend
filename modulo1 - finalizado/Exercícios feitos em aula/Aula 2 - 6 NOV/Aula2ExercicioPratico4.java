package deborah.dbc;
import java.util.Scanner;

public class Aula2ExercicioPratico4 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String palavra = " ";

    while(!palavra.equalsIgnoreCase("fim")) {
        System.out.print("Digite uma palavra (digite \"fim\" para encerrar): ");
        palavra = scanner.nextLine();
        System.out.println(palavra);
    }

    }
}
