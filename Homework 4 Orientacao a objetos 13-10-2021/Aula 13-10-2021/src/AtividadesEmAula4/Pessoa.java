package AtividadesEmAula4;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;
    private String whatsApp;

    public Pessoa() {

    }
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public void conversar(Pessoa pessoa) {
        System.out.println(this.nome + " conversou com " + pessoa.nome);
    }

    public String retornarNomeCompleto() {
        return nome + " " + sobrenome;
    }

    public boolean ehMaiorDeIdade() {
        return idade >= 18;
    }

    public void mandarWhats(Pessoa pessoa, String msg) {
        System.out.println(nome + " enviou: " + msg + " para " + pessoa.nome);
    }
    @Override
    public String toString() {
        return "Nome: "+nome + " Sobrenome: "+sobrenome +" Idade: " + idade + " Whatsapp: " + whatsApp;
    }
}
