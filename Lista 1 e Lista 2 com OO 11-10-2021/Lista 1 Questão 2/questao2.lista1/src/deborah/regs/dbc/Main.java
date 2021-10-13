package deborah.regs.dbc;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int [] notas = new int[4];

        System.out.println("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        int i = 0;
        while(i != notas.length) {
            System.out.print("Digite a nota da " + (i+1) + "ª avaliação: ");
            notas[i] = scanner.nextInt();
            i++;
        }

        Aluno aluno = new Aluno(nome,notas);
        aluno.setNome(nome);
        aluno.setNotaProvas(notas);
        System.out.println(aluno.toString());

    }
}
