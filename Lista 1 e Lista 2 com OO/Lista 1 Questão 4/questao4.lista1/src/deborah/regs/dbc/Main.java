package deborah.regs.dbc;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cidade cidade1 = new Cidade("Porto Alegre",0.805," 1 492 530");
        Cidade cidade2 = new Cidade("Caxias do Sul",0.782,"517 451");
        Cidade cidade3 = new Cidade("Belo Horizonte",0.810,"2 530 701");
        Cidade cidade4 = new Cidade("Ouro Preto", 0.741, "73 994");
        Cidade cidade5 = new Cidade("Recife", 0.772,"1 661 017");
        Cidade cidade6 = new Cidade("Olinda", 0.735,"393 115");

        Cidade [] cidadesRS = {cidade1,cidade2};
        Cidade [] cidadesMG = {cidade3,cidade4};
        Cidade [] cidadesPE = {cidade5,cidade6};


        Estado estado1 = new Estado("Rio grande do Sul", cidadesRS);
        Estado estado2 = new Estado("Minas Gerais", cidadesMG);
        Estado estado3 = new Estado("Pernambuco", cidadesPE);

        System.out.println("Escola um estado: \n"+"1- " +estado1.getNome() + "\n2- " + estado2.getNome() + "\n3- "+ estado3.getNome());
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 1) {
            estado1.menuCidades();
        }
        if (opcao == 2) {
            estado2.menuCidades();
        }
        if (opcao == 3) {
            estado3.menuCidades();
        }

    }
}
