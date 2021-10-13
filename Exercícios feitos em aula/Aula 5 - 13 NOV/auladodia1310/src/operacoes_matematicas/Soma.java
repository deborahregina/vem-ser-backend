package operacoes_matematicas;

public class Soma implements OperacaoMatematica {

    @Override
    public int calcula(int a, int b) {
        return a+b;
    }
}
