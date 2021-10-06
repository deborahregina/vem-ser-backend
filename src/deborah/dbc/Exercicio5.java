package deborah.dbc;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor pago por hora trabalhada: ");
        float valorDaHora = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Digite o número de horas inteiras normais trabalhadas: ");
        int numeroDeHoras = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o número horas inteiras extras trabalhadas (50%): ");
        float numeroHorasExtras50 = scanner.nextFloat();
        System.out.println("Digite o número de horas inteiras extras trabalhadas (100%): ");
        float numeroHorasExtras100 = scanner.nextFloat();
        double salarioMensal = valorDaHora*numeroDeHoras+ numeroHorasExtras100*valorDaHora*2 + numeroHorasExtras50*valorDaHora*1.5;
        System.out.println(String.format("O Salário do funcionário é R$%.2f: ",salarioMensal));
    }
}
