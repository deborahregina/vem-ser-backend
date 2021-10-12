package deborah.regs.dbc;
import java.util.Scanner;

public class Estado {
    private String nome;
    private Cidade [] cidades = new Cidade[2];

    public Estado(){

    }
    public Estado(String nome, Cidade [] cidades) {
        this.nome = nome;
        this.cidades = cidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade[] getCidades() {
        return cidades;
    }

    public void setCidades(Cidade[] cidades) {
        this.cidades = cidades;
    }

    public void menuCidades() {
        System.out.println("Escolha uma cidade: \n1- " + cidades[0].getNome() + "\n2- " + cidades[1].getNome());
        int opcaocidade = Main.scanner.nextInt();
        System.out.println(getCidades()[opcaocidade-1].toString());
    }
}
