package deborah.dbc;
import java.util.Scanner;

public class Lista1Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor total consumido: ");
        float valorConsumido = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Digite o valor pago pelo cliente: ");
        float valorPago = scanner.nextFloat();
        scanner.nextLine();
        if (valorPago < valorConsumido) {
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido.");
        }
        else {
            float troco = valorPago - valorConsumido;
            System.out.println("O troco deve ser: " + troco);
        }
    }
}
