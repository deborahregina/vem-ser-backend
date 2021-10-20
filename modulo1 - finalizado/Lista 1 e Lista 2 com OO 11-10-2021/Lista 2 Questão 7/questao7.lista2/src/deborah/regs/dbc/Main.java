package deborah.regs.dbc;

import java.util.Scanner;

public class Main {
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    OperaMatrizes matrix = new OperaMatrizes();

    matrix.completaMatriz();
        int i = matrix.quantosNumerosMaioresque10();
        System.out.println("Existem " + i + " números maiores que 10.");
    }
}
