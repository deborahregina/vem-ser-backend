package deborah.regs.dbc;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [][] matrixAux = new int [5][4];


        for (int i = 0; i < 5; i++){
            System.out.print("Digite o numero de matrícula do aluno " + (i+1) +": ");
            matrixAux[i][0] = scanner.nextInt();
            System.out.print("Digite a média das provas do aluno "+ (i+1) + ": ");
            matrixAux[i][1] = scanner.nextInt();
            System.out.print("Digite a média dos trabalhos do aluno "+ (i+1)+ ": ");
            matrixAux[i][2] = scanner.nextInt();
            matrixAux[i][3] = (int) (matrixAux[i][1]*0.6 + matrixAux[i][2]*0.4);
        }
        Alunos alunos = new Alunos(matrixAux);
        alunos.imprimeResultados();
    }
}
