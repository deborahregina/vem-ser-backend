package deborah.dbc;
import java.util.Scanner;

public class Lista2Exercicio8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int [][] informacoesAlunos = new int[5][4];
        double [] notaFinal = new double [5];

        for (int i = 0; i < 5; i++){
                System.out.print("Digite o numero de matrícula do aluno " + (i+1) +": ");
                informacoesAlunos[i][0] = scanner.nextInt();
                System.out.print("Digite a média das provas do aluno "+ (i+1) + ": ");
                informacoesAlunos[i][1] = scanner.nextInt();
                System.out.print("Digite a média dos trabalhos do aluno "+ (i+1)+ ": ");
                informacoesAlunos[i][2] = scanner.nextInt();
            }

        double somaNotasFinais = 0;
        for (int i = 0; i < 5; i++) {
            notaFinal[i] = informacoesAlunos[i][1]*0.6 + informacoesAlunos[i][2]*0.4;
            somaNotasFinais += notaFinal[i];
        }
        int matriculaDaMaiorNota = 0;
        double maiorMedia = notaFinal[0];
        for (int i = 0; i < 5; i++) {
            if (maiorMedia < notaFinal[i]) {
                maiorMedia = notaFinal[i];
                matriculaDaMaiorNota = i;
            }
        }
        System.out.println("----- Resultado da turma ----------");
        System.out.println(String.format("A maior nota final é %.2f", maiorMedia));
        System.out.println(String.format("A média das notas finais é %.2f",somaNotasFinais/5));

        }
    }
