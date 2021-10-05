package deborah.dbc;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor pago por hora trabalhada: ");
        float valorDaHora = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Digite o número de horas normais trabalhadas: ");
        int numeroDeHoras = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o número horas extras trabalhadas: ");
        int numeroHorasExtras = scanner.nextInt();
        double salarioMensal = valorDaHora*numeroDeHoras + valorDaHora*numeroHorasExtras*0.5;
        System.out.println(String.format("O Salário do funcionário é R$%.2f: ",salarioMensal));
    }
}
