package deborah.regs.dbc;

public class Aluno {

   private String nome;
   private int [] notaProvas = new int[3];

    public Aluno(String nome, int[] notaProvas) {
        this.nome = nome;
        this.notaProvas = notaProvas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[] getNotaProvas() {
        return notaProvas;
    }

    public void setNotaProvas(int[] notaProvas) {
        this.notaProvas = notaProvas;
    }

    @Override
    public String toString() {
        return "Médias do aluno " +nome + ":\nProva 1 " + notaProvas[0] + "\nprova 2: " + notaProvas[1] + "\nprova 3: " + notaProvas[2] + "\nprova 4: " + notaProvas[3] +
                "\nMédia total: " +calculaMedia();

    }
    public double calculaMedia() {
        return (notaProvas[0] + notaProvas[1] +notaProvas[2] + notaProvas[3])/4;
    }
}
