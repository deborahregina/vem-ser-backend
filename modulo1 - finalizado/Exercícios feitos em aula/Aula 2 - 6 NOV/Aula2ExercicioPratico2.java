package deborah.dbc;

public class Aula2ExercicioPratico2 {
    public static void main(String[] args) {
        int [][] numeros = new int[2][2];
        numeros[0][0] = 2;
        numeros[0][1] = 3;
        numeros [1][0] = 2;
        numeros [1][1] = 3;


        int soma = numeros[0][0]+numeros[0][1]+numeros[1][0]+numeros[1][1];

        int somaPrimeiraLinha = numeros[0][0]+numeros[0][1];
        System.out.println("soma primeira linha: "+somaPrimeiraLinha);
        int somaSegundaLinha = numeros[1][0]+numeros[1][1];
        System.out.println("soma segunda linha: "+somaPrimeiraLinha);
        int diferencaEntreLinhas = somaPrimeiraLinha - somaSegundaLinha;
        System.out.println(diferencaEntreLinhas);
        int somaPrimeiraColuna = numeros[0][0]+numeros[1][0];
        System.out.println("soma primeira coluna: "+somaPrimeiraColuna);
        int somaSegundaColuna = numeros[1][0] + numeros[1][1];
        System.out.println("soma segunda coluna: "+somaSegundaColuna);
        int diferencaEntreColunas = somaPrimeiraColuna - somaSegundaColuna;
        System.out.println(diferencaEntreColunas);
    }
}
