package deborah.regs.dbc;

public class OperaMatrizes {
    int [][] matriz = new int[4][4];

    public OperaMatrizes() {

    }
    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public void completaMatriz(){
        int [][] matrizaux = new int[4][4];

        for (int i = 0; i < matrizaux.length ; i++) {
            for (int j = 0; j < matrizaux.length; j++) {
                System.out.print("matriz["+i+"]"+"["+j+"]"+" =");
                matrizaux[i][j] = Main.scanner.nextInt();
            }
        }
            this.matriz = matrizaux;
    }
    public int quantosNumerosMaioresque10() {
        int contaNumeros = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] > 10) {
                    System.out.println("O valor da linha "+i+" coluna "+j + " é maior que 10, ele é :" + matriz[i][j]);
                    contaNumeros++;
                }
            }
        }
        return contaNumeros;
    }
}
