package deborah.dbc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Pessoa pessoa1 = new Pessoa();
        pessoa1.nome = "Deborah";
        pessoa1.sobrenome = "Silveira";
        pessoa1.idade = 30;
        pessoa1.whatsapp = "33333333";

        Pessoa pessoa2 = new Pessoa();
        pessoa2.nome = "Danielle";
        pessoa2.sobrenome = "Silveira";
        pessoa2.idade = 28;
        pessoa2.whatsapp = "9999999";

        pessoa1.conversou(pessoa2);
        boolean teste = pessoa1.ehMaiorDeIdade();
        System.out.println(teste);
        String nomecompleto = pessoa2.retornarNomeCompleto();
        System.out.println(nomecompleto);
        pessoa1.mandarWhatsApp(pessoa2,"gostei da aula! ");
    }
}
