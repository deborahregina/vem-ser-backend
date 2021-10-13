package operacoes_matematicas;

public class Main {
    public static void main(String[] args) {

        int a = 10;
        int b = 2;

        Soma soma = new Soma();
        Subtracao subtracao = new Subtracao();
        Multiplicacao multiplicacao = new Multiplicacao();
        Divisao divisao = new Divisao();

        System.out.println("Resultado da soma: " +soma.calcula(10,2));
        System.out.println("Resultado da subtração: " +subtracao.calcula(10,2));
        System.out.println("Resultado da Multiplicacao: " +multiplicacao.calcula(10,2));
        System.out.println("Resultado da Divisao: " +divisao.calcula(10,2));

    }
}
