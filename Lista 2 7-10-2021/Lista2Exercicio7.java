package deborah.dbc;
import java.util.Scanner;

public class Lista2Exercicio7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int [][] matrix = new int[4][4];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
            System.out.print("matriz["+i+"]"+"["+j+"]"+" =");
            matrix[i][j] = scanner.nextInt();
            }
        }
        int contaNumeros = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > 10) {
                    System.out.println("O valor da linha "+i+" coluna "+j + " é maior que 10, ele é :" + matrix[i][j]);
                    contaNumeros++;
                }
            }
        }
        System.out.println("O número de elementos maior que 10 é: "+contaNumeros);
    }
}
