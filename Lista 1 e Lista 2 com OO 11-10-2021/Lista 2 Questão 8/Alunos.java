package deborah.regs.dbc;

public class Alunos {
    private int [][] infosAlunos;
    private int matriculaMaiorNota;
    private int somaNotasFinais;
    private int maiorNota;

    public Alunos(int[][] infosAlunos) {
        this.infosAlunos = infosAlunos;
    }

    public int[][] getInfosAlunos() {
        return infosAlunos;
    }

    public void setInfosAlunos(int[][] infosAlunos) {
        this.infosAlunos = infosAlunos;
    }


    public int notasFinais() {
        somaNotasFinais = 0;
        for (int k = 0; k < 5; k++) {
            somaNotasFinais += infosAlunos[k][3];
        }
        return somaNotasFinais;
    }

    public int matriculaMaiorNota() {
        matriculaMaiorNota = 0;
        double maiorMedia = 0;
        for (int i = 0; i < 5; i++) {
            if (maiorMedia < infosAlunos[i][3]) {
                maiorMedia = infosAlunos[i][3];
                matriculaMaiorNota = infosAlunos[i][0];
            }
        }
        return matriculaMaiorNota;
    }
    public int maiorNota() {
        maiorNota = 0;
        for (int j = 0; j < 5; j++) {
            if (maiorNota < infosAlunos[j][3]) {
                maiorNota = infosAlunos[j][3];
            }
        }
        return maiorNota;
    }

    public void imprimeResultados() {
        System.out.println("----- Resultado da turma ----------");
        System.out.println("A matricula do aluno que teve maior nota foi: "+ matriculaMaiorNota());
        System.out.println("A maior nota final é:" + maiorNota());
        System.out.println("A média das notas finais é:"+ (notasFinais()/5));
    }
}
