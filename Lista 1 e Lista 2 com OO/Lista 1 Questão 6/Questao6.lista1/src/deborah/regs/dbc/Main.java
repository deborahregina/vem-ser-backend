package deborah.regs.dbc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Palavra palavra1 = new Palavra("Cachorro","Dog");
        Palavra palavra2 = new Palavra("Tempo","Time");
        Palavra palavra3 = new Palavra("Amor","Love");
        Palavra palavra4 = new Palavra("Cidade","City");
        Palavra palavra5 = new Palavra("Feliz","Happy");

        System.out.println("Digite a palavra que deseja traduzir: ");
        String palavra = scanner.nextLine();

        if (palavra.equalsIgnoreCase(palavra1.getPalavraEmPt()) || palavra.equalsIgnoreCase(palavra1.getPalavraEmIngles())) {
            palavra1.traducao(palavra);
        }
        else if (palavra.equalsIgnoreCase(palavra2.getPalavraEmPt()) || palavra.equalsIgnoreCase(palavra2.getPalavraEmIngles())) {
            palavra2.traducao(palavra);
        }
        else if (palavra.equalsIgnoreCase(palavra3.getPalavraEmPt()) || palavra.equalsIgnoreCase(palavra3.getPalavraEmIngles())) {
            palavra3.traducao(palavra);
        }
        else if (palavra.equalsIgnoreCase(palavra4.getPalavraEmPt()) || palavra.equalsIgnoreCase(palavra4.getPalavraEmIngles())) {
            palavra4.traducao(palavra);
        }
        else if (palavra.equalsIgnoreCase(palavra5.getPalavraEmPt()) || palavra.equalsIgnoreCase(palavra5.getPalavraEmIngles())) {
            palavra3.traducao(palavra);
        }
        else {
            System.out.println("Opção inválida");
        }
    }

}
