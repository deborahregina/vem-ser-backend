package deborah.dbc;

public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    String whatsapp;

    public void conversou(Pessoa pessoa) {
        System.out.println(this.nome + " conversou com "+pessoa.nome);
    }
    public String retornarNomeCompleto() {
        String nomeCompleto;
        return nomeCompleto = nome + " " + sobrenome;
    }
    public boolean ehMaiorDeIdade() {
        boolean ehMaior;
        if (this.idade > 18) {
            ehMaior = true;
        }
        else {
            ehMaior = false;
        }
        return ehMaior;
    }
    public void mandarWhatsApp(Pessoa pessoa, String mensagem) {
        System.out.println(this.nome + " enviou: "+ mensagem+ "para "+pessoa.nome);
    }

}
