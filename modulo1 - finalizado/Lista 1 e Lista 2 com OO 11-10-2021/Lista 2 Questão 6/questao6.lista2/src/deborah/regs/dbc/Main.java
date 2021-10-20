package deborah.regs.dbc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int [] lista = {1,2,3,4,5,6,7,8,9,10};
        ListadeNumeros listanum = new ListadeNumeros(lista);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número que deseja buscar: ");
        int num = scanner.nextInt();
        listanum.procuraNumero(num);

    }
}
