package deborah.dbc;

public class Aula2ExercicioPratico1 {
    public static void main(String[] args) {
        int [] numeros = new int[3];

        numeros[0]=2;
        numeros[1]=3;
        numeros[2]=10;

        int soma = numeros[0]+numeros[1]+numeros[2];
        float media = soma/(numeros.length);
        System.out.println("A soma dos componentes é: "+soma+"\nA média dos componentes é: "+media);
    }
}
