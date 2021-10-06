package deborah.dbc;
import java.util.Scanner;

public class Lista2Exercicio6 {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int [] numerosInteiros = {0,1,2,3,4,5,6,7,8,9};
    int numeroProcurado;
    boolean pertence = false;

        System.out.print("Digite o número que deseja buscar: ");
        numeroProcurado = scanner.nextInt();
        for(int i = 0; i < numerosInteiros.length; i++) {
            if (numeroProcurado == numerosInteiros[i]) {
                System.out.println("O número está na lista, na posição " + i);
                pertence = true;
            }
        }
        if (!pertence){
            System.out.println("O número não está na lista.");
        }
    }
}
