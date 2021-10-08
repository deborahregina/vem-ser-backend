package deborah.dbc;

public class Exercicio1 {
    public static void main(String[] args) {
        String[] valores = {"01234", "5680.8", "670.2"};

        Integer codigoFuncionario = Integer.valueOf(valores[0]);
        Double salario = Double.valueOf(valores[1]);
        Double descontos = Double.valueOf(valores[2]);
        System.out.println("O salário menos descontos é: "+(salario-descontos));
    }
}
