package deborah.regs.dbc;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static DecimalFormat df = new DecimalFormat("#,###.##");
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario();

        funcionario.menuDeCalculo();
        System.out.println(funcionario.calculaSalario());
    }
}
