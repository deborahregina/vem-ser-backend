package AtividadesEmAula4;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maicon");
        pessoa.setSobrenome("machado");
        pessoa.setIdade(30);
        pessoa.setWhatsApp("51995869866");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("maria");
        pessoa2.setSobrenome("machado");
        pessoa2.setIdade(28);
        pessoa2.setWhatsApp("51995868866");

        Pessoa pessoa3 = new Pessoa("Deborah",30);
        System.out.println(pessoa3);

        //System.out.println(pessoa.ehMaiorDeIdade());
        //System.out.println(pessoa2.ehMaiorDeIdade());

        //pessoa.conversar(pessoa2);

        //System.out.println(pessoa.retornarNomeCompleto());
        //pessoa.mandarWhats(pessoa2, "Olá, gosta de java?");
    }
}
