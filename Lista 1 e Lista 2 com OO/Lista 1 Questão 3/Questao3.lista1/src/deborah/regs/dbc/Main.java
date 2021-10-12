package deborah.regs.dbc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor total consumido: ");
        double valorConsumo = scanner.nextDouble();
        System.out.println("Digite o valor pago pelo cliente: ");
        double valorPago = scanner.nextDouble();

        Compra compra = new Compra(valorConsumo,valorPago);

        System.out.println(compra.toString());

    }
}
