public class Pessoa {

    private String nome;
    private int idade;
    private String cidade;
    private String estado;

    public Pessoa(String nome, int idade, String cidade, String estado) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {

        return idade;
    }

    public void setIdade(int idade) {

        this.idade = idade;
    }

    public String getCidade() {

        return cidade;
    }

    public void setCidade(String cidade) {

        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Olá seu nome é " + nome + " você tem " + idade+ " anos," + " é da cidade de " + cidade +", situada no estado de " + estado;
    }
}
