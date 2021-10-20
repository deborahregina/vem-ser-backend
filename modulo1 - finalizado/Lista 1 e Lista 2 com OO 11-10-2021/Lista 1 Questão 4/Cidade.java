package deborah.regs.dbc;

public class Cidade {

    private String nome;
    private double idh;
    private String populacao;
    private String [] festas = new String[2];

    public Cidade(String nome, double idh, String populacao) {
        this.nome = nome;
        this.idh = idh;
        this.populacao = populacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getIdh() {
        return idh;
    }

    public void setIdh(double idh) {
        this.idh = idh;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public String[] getFestas() {
        return festas;
    }

    public void setFestas(String[] festas) {
        this.festas = festas;
    }
    public String printaNome() {
        return nome;
    }
    @Override
    public String toString() {
        return "* O nome da cidade é: "+ nome + "\n* A população da cidade é: " + populacao + "\n* As festas principais são: " + festas[0] + " " + festas[1] + "\n* E o IDH é: " + idh;
    }
}
